package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;
import com.example.thinkpad.apps.dao.utils.CheckString;

public class RegActivity extends Activity implements View.OnClickListener {
    private EditText mEdtRegname;
    private EditText mEdtRegpwd;
    private EditText mEdtRegtel;
    private RadioGroup mRgSex;
    private RadioButton mRbMan;
    private RadioButton mRbWoman;
    private Button mBtBirth;
    private ImageView mImgvHead;
    private Button mBtReggo;
    private Button mBtRegcancel;
    private DatePickerDialog dpd;
    private Dialog dig_head;
    private GridView mGvHead;
    private int[] imgs_head={R.drawable.img0,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8};
    private HeadAdapter mHeadAdapter;
    private IUserDao userDao;
    private int headPos;
    private AlertDialog.Builder mBuilder;
    private  AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        mEdtRegname=findViewById(R.id.edt_regname);
        mEdtRegpwd=findViewById(R.id.edt_regpwd);
        mEdtRegtel=findViewById(R.id.edt_regtel);
        mRgSex=findViewById(R.id.rg_sex);
        mRbMan=findViewById(R.id.rb_man);
        mRbWoman=findViewById(R.id.rb_woman);
        mBtBirth=findViewById(R.id.bt_birth);
        mImgvHead=findViewById(R.id.imgv_head);
        mBtReggo=findViewById(R.id.bt_reggo);
        mBtRegcancel=findViewById(R.id.bt_regcancel);
        //给确定注册或取消注册加监听
        mBtReggo.setOnClickListener(this);
        mBtRegcancel.setOnClickListener(this);
        userDao= UserDaoDBImpl.getDao(this);

        //出生日期对话框-------------------------
        dpd=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mBtBirth.setText(year+"年 "+(monthOfYear+1)+"月 "+dayOfMonth+"日");
            }
        },1999,1,31);


        //出生日期对话框-------------------------

        //头像对话框--------------------
        dig_head=new Dialog(this);
        dig_head.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dig_head.setContentView(R.layout.gv_headlayout);
        mGvHead=dig_head.findViewById(R.id.gv_head);
        mHeadAdapter=new HeadAdapter(this,imgs_head);
        mGvHead.setAdapter(mHeadAdapter);
        //设置gridview条目单击监听
        mGvHead.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                mImgvHead.setImageResource(imgs_head[position]);
                dig_head.cancel();
                headPos=position;
            }

        });


        //头像对话框--------------------

        //注册成功后的对话框----------------------
        mBuilder=new AlertDialog.Builder(this);
        mBuilder.setTitle("");
        mBuilder.setMessage("恭 喜 你 注 册 成 功");
        mBuilder.setPositiveButton("返回主页登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               mEdtRegname.setText("");
               mEdtRegpwd.setText("");
               mEdtRegtel.setText("");
               mBtBirth.setText("请选择出生日期");
               mImgvHead.setImageResource(R.drawable.img0);
               RegActivity.this.finish();

            }
        });
        alertDialog=mBuilder.create();

    }

    //选择头像按钮的onclick()
    public void choose_head(View v){
        dig_head.show();

    }

    //选择出生日期的onclick()
    public void choose_birth(View v){
        dpd.show();
    }

    public void askGoOn(){
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_reggo:
                String name=mEdtRegname.getText().toString();
                String pwd=mEdtRegpwd.getText().toString();
                if(CheckString.check(name)&&CheckString.check(pwd)){
                    if(!userDao.findUserByName(name)){
                        //获取性别
                        String sex="";
                         if(mRgSex.getCheckedRadioButtonId()==R.id.rb_man){
                             sex="男";
                         }else {
                             sex="女";
                         }
                        //获取电话号码
                        String tels=mEdtRegtel.getText().toString();
                         //获取头像
                        int headImg=imgs_head[headPos];
                        //获取出生日期
                        String birth=mBtBirth.getText().toString();
                        //将数据存入数据库
                        User u=new User();
                        u.setName(name);
                        u.setPwd(pwd);
                        u.setTel(tels);
                        u.setSex(sex);
                        u.setHeadImg(headImg);
                        u.setBirth(birth);
                        userDao.addUser(u);
                        askGoOn();
                    }else{
                        Toast.makeText(this, "用户名已被注册，请尝试登录", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, "用户名或密码格式错误，请重新输入", Toast.LENGTH_SHORT).show();
                    mEdtRegname.setText("");
                    mEdtRegpwd.setText("");

                }

                break;
            case R.id.bt_regcancel:
                //退出一个activity
                this.finish();
                break;
        }
    }
}
