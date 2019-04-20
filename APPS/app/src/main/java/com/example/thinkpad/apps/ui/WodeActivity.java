package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;

public class WodeActivity extends Activity implements View.OnClickListener {
    private ImageView head;
    private TextView name;
    private Button xinxi;
    private Button paoshou;
    private Button dizhi;
    private Button gengduo;
    private Button kefu;
    private Button zhuye;
    private Button dingdan;
    private Button wode;
    private MyOpenHelper mOpenHelper;
    private String namer;
    private AlertDialog alertDialog3;
    private AlertDialog.Builder mBuilder3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode);
        //实例化
        head=findViewById(R.id.wo_head);
        name=findViewById(R.id.wo_name);
        xinxi=findViewById(R.id.wo_xinxi);
        paoshou=findViewById(R.id.wo_paoshou);
        dizhi=findViewById(R.id.wo_dizhi);
        gengduo=findViewById(R.id.wo_gengduo);
        kefu=findViewById(R.id.wo_kefu);
        zhuye=findViewById(R.id.wo_zhuye);
        dingdan=findViewById(R.id.wo_dingdan);
        wode=findViewById(R.id.wo_wode);
        wode.setEnabled(false);
        mOpenHelper=new MyOpenHelper(this);

        //设置按钮的监听
        xinxi.setOnClickListener(this);
        paoshou.setOnClickListener(this);
        dizhi.setOnClickListener(this);
        gengduo.setOnClickListener(this);
        kefu.setOnClickListener(this);
        zhuye.setOnClickListener(this);
        dingdan.setOnClickListener(this);
        name.setText("    "+WelcomeActivity.Noname);
        //数据库查询
        check();
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

    private void check() {
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        String sql="select * from user where name=?";
        Cursor cursor=db.rawQuery(sql,new String[]{WelcomeActivity.Noname});
        while(cursor.moveToNext()){
            namer=cursor.getString(cursor.getColumnIndex("name"));
            head.setImageResource(cursor.getInt(cursor.getColumnIndex("headImg")));//设置头像

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wo_xinxi:
                Intent intent2=new Intent(this,PersonActivity.class);
                startActivity(intent2);

                finish();
                break;
            case R.id.wo_paoshou:
                Intent intent3=new Intent(this,ResultActivity3.class);
                startActivity(intent3);
                break;
            case R.id.wo_dizhi:
                Toast.makeText(this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wo_gengduo:
                Toast.makeText(this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wo_kefu:
                Toast.makeText(this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wo_zhuye:
                Intent intent=new Intent(this,jinru.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;
            case R.id.wo_dingdan:
                Intent intent1=new Intent(this,ResultActivity2.class);
                startActivity(intent1);
                this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
                finish();
                break;
        }

    }
    public void onBackPressed() {
        alertDialog3.show();
    }
}
