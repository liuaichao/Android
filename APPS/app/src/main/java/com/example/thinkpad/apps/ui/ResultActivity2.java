package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.thinkpad.apps.IUserDao2;
import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl2;

public class ResultActivity2 extends Activity implements View.OnClickListener {
     private ListView mListRes;
     private ResultAdapter2 mAdapter;
     private IUserDao2 userDao2;
     private Button dn_zhuye;
     private Button dn_dingdan;
     private Button dn_wode;
     private AlertDialog alertDialog3;
    private AlertDialog.Builder mBuilder3;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        userDao2=UserDaoDBImpl2.getDao(this,WelcomeActivity.Noname,null,1);
        mListRes=findViewById(R.id.list_res);
        mAdapter=new ResultAdapter2(this,userDao2.showAll());
        mListRes.setAdapter(mAdapter);
        //初始化
        dn_zhuye=findViewById(R.id.zd_zhuye2);
        dn_dingdan=findViewById(R.id.zd_dingdan);
        dn_dingdan.setEnabled(false);
        dn_wode=findViewById(R.id.zd_wode2);
        //对按钮加监听
        dn_zhuye.setOnClickListener(this);
        dn_wode.setOnClickListener(this);

        //返回键监听提示框
        mBuilder3=new AlertDialog.Builder(this);
        mBuilder3.setTitle("");
        mBuilder3.setMessage("您 确 定 要 退 出 吗");
        mBuilder3.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                alertDialog3.dismiss();

            }
        });
        mBuilder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog3.dismiss();

            }
        });
        alertDialog3=mBuilder3.create();
    }


    public void onBackPressed() {
        alertDialog3.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zd_zhuye2:
                Intent intent=new Intent(this,jinru.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;
            case R.id.zd_wode2:
                Intent intent1=new Intent(this,WodeActivity.class);
                startActivity(intent1);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;
        }


    }
}
