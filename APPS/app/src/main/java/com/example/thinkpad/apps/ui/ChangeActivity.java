package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;
import com.example.thinkpad.apps.dao.utils.CheckString;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;

public class ChangeActivity extends Activity implements View.OnClickListener {
    private ImageButton fanhui;
    private EditText oldpwd;
    private EditText newpwd;
    private EditText renewpwd;
    private Button enter;
    private IUserDao userDao;
    private MyOpenHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        fanhui=findViewById(R.id.xg_fanhui);
        oldpwd=findViewById(R.id.xg_oldpwd);
        newpwd=findViewById(R.id.xg_newpwd);
        renewpwd=findViewById(R.id.xg_renewpwad);
        enter=findViewById(R.id.xg_enter);
        //监听
        fanhui.setOnClickListener(this);
        enter.setOnClickListener(this);
        userDao= UserDaoDBImpl.getDao(this);
        mOpenHelper=new MyOpenHelper(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.xg_fanhui:
                Intent intent=new Intent(this,PersonActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.xg_enter:
                String old=oldpwd.getText().toString().trim();
                String news=newpwd.getText().toString().trim();
                String renew=renewpwd.getText().toString().trim();
                String name=WelcomeActivity.Noname;
                if(CheckString.check(news)){
                    if(userDao.findUserPwd(old)&&news.equals(renew)){
                        Toast.makeText(this, "密码修改成功，请重新登录", Toast.LENGTH_SHORT).show();
                        //数据库进行修改
                        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
                        ContentValues contentValues=new ContentValues();
                        contentValues.put("pwd",news);
                        db.update("user",contentValues,"name=?",new String[]{name});
                        db.close();

                        Intent intent1=new Intent(this,WelcomeActivity.class);
                        startActivity(intent1);
                        this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                        finish();
                    }else if(userDao.findUserPwd(old)==false){
                        Toast.makeText(this, "旧密码输入不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }else if((userDao.findUserPwd(old)==true)&&(news.equals(renew)==false)){
                        Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "密码中含有非法字符或密码长度短", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
