package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;
import com.example.thinkpad.apps.dao.utils.CheckString;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;

public class WelcomeActivity extends Activity implements View.OnClickListener{

    private Button item_login;
    private Button item_reg;
    private EditText mEdtLoginname;//用户名输入框
    private EditText mEdtLoginpwd;//密码输入框
    private Button mBtLogingo;
    private Button mBtLogincancel;
    private IUserDao userDao;
    private Button denglu;
    private Button zhuce;
    private Dialog  dig_login;
    private UserDaoDBImpl userDaoDB;
    public static String Noname;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        userDao=UserDaoDBImpl.getDao(this);
        dig_login=new Dialog(this);
        dig_login.setContentView(R.layout.login_dig);
        dig_login.setTitle("登录");
        denglu=(Button) findViewById(R.id.denglu);//登录按钮
        zhuce=(Button) findViewById(R.id.zhuce);//注册按钮
        //登录界面监控
        mEdtLoginname=(EditText)dig_login.findViewById(R.id.edt_loginname);
        mEdtLoginpwd=(EditText)dig_login.findViewById(R.id.edt_loginpwd);
        mBtLogingo=(Button)dig_login.findViewById(R.id.bt_logingo);
        mBtLogincancel=(Button)dig_login.findViewById(R.id.bt_logincancel);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        mBtLogingo.setOnClickListener(this);
        mBtLogincancel.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denglu://登录进入监听
                dig_login.show();
                break;
            case R.id.bt_logingo://登录监听
                String name=mEdtLoginname.getText().toString();
                String pwd=mEdtLoginpwd.getText().toString();
                if(CheckString.check(name)&&CheckString.check(pwd)){
                    //判断数据库中是否有数据，能否登录
                    if(userDao.findUserByNameAndPwd(name,pwd)){
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, "请开启地图定位权限", Toast.LENGTH_SHORT).show();
                        Noname=name;
                        Intent intent=new Intent(this,jinru.class);
                        startActivity(intent);
                        this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                        dig_login.cancel();
                        finish();
                    }else if(name.equals("liuaichao")&&pwd.equals("123456")){
                        Toast.makeText(this, "进入管理员模式", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(this,ResultActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "用户名或密码格式错误，请重新输入", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.bt_logincancel://取消监听
                dig_login.cancel();
                break;
            case R.id.zhuce:
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,RegActivity.class);
                startActivity(intent);
                break;

        }

    }
}



