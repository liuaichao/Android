package com.example.thinkpad.apps.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao3;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl3;


public class ResultActivity3 extends Activity implements View.OnClickListener {
    private ListView mListRes;
    private ResultAdapter3 mAdapter;
    private IUserDao3 userDao3;
    private ImageButton fanhui;


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);
        userDao3= UserDaoDBImpl3.getDao(this);
        mListRes=findViewById(R.id.list_res);
        mAdapter=new ResultAdapter3(this,userDao3.showAll());
        mListRes.setAdapter(mAdapter);
        //初始化
        fanhui=findViewById(R.id.ps_fanhui3);


        //对按钮加监听
        fanhui.setOnClickListener(this);


    }


    public void onBackPressed() {
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ps_fanhui3:
                Intent intent = new Intent(this, WodeActivity.class);
                startActivity(intent);
                this.finish();
                break;

        }

    }
}