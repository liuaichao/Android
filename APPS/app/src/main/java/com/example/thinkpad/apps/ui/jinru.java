package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Date;

import com.example.thinkpad.apps.IUserDao2;
import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao3;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.entity.User3;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl2;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl3;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperPao;
import com.example.thinkpad.apps.map.Ditu;

import java.util.ArrayList;
import java.util.List;

public class jinru extends Activity implements View.OnClickListener {
    private TextView dn_didian;
    private ImageButton dn_ditu;
    private EditText dn_qidian;
    private EditText dn_zhongdian;
    private EditText dn_jiner;
    private EditText dn_neirong;
    private Spinner dn_spinner;
    private Button dn_tijiao;
    private Button dn_zhuye;
    private Button dn_dingdan;
    private Button dn_wode;
    private List<String> list;
    private Date loca_time;
    private IUserDao2 userDao;
    private IUserDao3 userDao3;
    private AlertDialog.Builder mBuilder2;
    private AlertDialog.Builder mBuilder3;
    private  AlertDialog alertDialog2;
    private  AlertDialog alertDialog3;
    private static MyOpenHelper mOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuye);
        //实例化对象
        dn_didian=findViewById(R.id.didian);
        dn_ditu=findViewById(R.id.ditu);
        dn_qidian=findViewById(R.id.zy_qidian);
        dn_zhongdian=findViewById(R.id.zy_zhongdian);
        dn_jiner=findViewById(R.id.zy_jiner);
        dn_neirong=findViewById(R.id.zy_neirong);
        dn_spinner=findViewById(R.id.spinner);
        dn_tijiao=findViewById(R.id.zy_tijiao);
        dn_zhuye=findViewById(R.id.zy_zhuye);
        dn_dingdan=findViewById(R.id.zy_dingdan);
        dn_wode=findViewById(R.id.zy_wode);
        mOpenHelper=new MyOpenHelper(this);

        //设置按钮的监听
        dn_ditu.setOnClickListener(this);//地图
        dn_tijiao.setOnClickListener(this);//提交
        dn_zhuye.setOnClickListener(this);//主页
        dn_zhuye.setEnabled(false);//主页
        dn_dingdan.setOnClickListener(this);//订单
        dn_wode.setOnClickListener(this);//我的
        dn_didian.setText(Ditu.weizhi);
        list = new ArrayList<String>();
        list.add("---请选择物品类型---");
        list.add("快递");
        list.add("食品");
        list.add("电子产品");
        list.add("大型物品>50kg");
        list.add("代购");
        list.add("其他");
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dn_spinner.setAdapter(adapter);
        //时间
        loca_time=new Date();
        userDao= UserDaoDBImpl2.getDao(this,WelcomeActivity.Noname,null,1);
        userDao3= UserDaoDBImpl3.getDao(this);
       //提交成功弹出对话框
        mBuilder2=new AlertDialog.Builder(this);
        mBuilder2.setTitle("");
        mBuilder2.setMessage("订 单 提 交 成 功");
        mBuilder2.setPositiveButton("返回主页", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dn_qidian.setText("");
                dn_zhongdian.setText("");
                dn_jiner.setText("");
                dn_neirong.setText("");

                alertDialog2.dismiss();
                adapter.notifyDataSetChanged();

            }
        });
        alertDialog2=mBuilder2.create();
        //返回键监听提示框
        mBuilder3=new AlertDialog.Builder(this);
        mBuilder3.setTitle("");
        mBuilder3.setMessage("您 确 定 要 退 出 吗");
        mBuilder3.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                alertDialog3.dismiss();
                adapter.notifyDataSetChanged();

            }
        });
        mBuilder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog3.dismiss();
                adapter.notifyDataSetChanged();

            }
        });
        alertDialog3=mBuilder3.create();


    }
    public void askGoOn2(){
        alertDialog2.show();
    }
    public void onBackPressed() {
        alertDialog3.show();
    }

    //按钮监听
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ditu:
                Intent intent=new Intent(this, Ditu.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.main_in4,R.anim.main_out4);
                finish();
                break;
            case R.id.zy_tijiao://提交订单按钮实现
                String name=WelcomeActivity.Noname;
                String qidian=dn_qidian.getText().toString();
                String zhongdian=dn_zhongdian.getText().toString();
                String jiner=dn_jiner.getText().toString();
                String neirong=dn_neirong.getText().toString();
                String time= loca_time.toLocaleString();
                //查找电话

                String tel;
                tel="";
                SQLiteDatabase db=mOpenHelper.getWritableDatabase();
                String sql="select * from user where name=?";
                Cursor cursor=db.rawQuery(sql,new String[]{name});
                while (cursor.moveToNext()){
                    tel=cursor.getString(cursor.getColumnIndex("tel"));
                }
                String state="未接单";
                User2 u=new User2();
                u.setStart(qidian);
                u.setFina(zhongdian);
                u.setRemark(neirong);
                u.setTime(time);
                u.setState(state);
                u.setNamer(name);
                userDao.addUser(u);
                //写入add数据库
                User3 u1=new User3();
                u1.setStart(qidian);
                u1.setFina(zhongdian);
                u1.setRemark(neirong);
                u1.setTime(time);
                u1.setState(state);
                u1.setNamer(name);
                u1.setTel(tel);
                userDao3.addUser(u1);

                askGoOn2();

                break;
            case R.id.zy_zhuye:
                break;
            case R.id.zy_dingdan:
                Intent intent1=new Intent(this,ResultActivity2.class);
                startActivity(intent1);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;
            case R.id.zy_wode:
                Intent intent2=new Intent(this,WodeActivity.class);
                startActivity(intent2);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;

        }

    }
}
