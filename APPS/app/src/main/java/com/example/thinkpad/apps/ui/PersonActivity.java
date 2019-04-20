package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;

public class PersonActivity extends Activity implements View.OnClickListener {
    private Button fanhui;
    private Button baocun;
    private Button tuichu;
    private Button xiugai;
    private ImageView head;
    private TextView zhanghao;
    private EditText tel;
    private MyOpenHelper mOpenHelper;
    private String namer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        //实例化
        fanhui=findViewById(R.id.ps_fanhui);
        baocun=findViewById(R.id.ps_baocun);
        tuichu=findViewById(R.id.ps_tuichu);
        xiugai=findViewById(R.id.ps_xiugai);
        head=findViewById(R.id.ps_head);
        zhanghao=findViewById(R.id.ps_zhanghao);
        tel=findViewById(R.id.ps_tel);
        mOpenHelper=new MyOpenHelper(this);
        //按钮监听
        fanhui.setOnClickListener(this);
        baocun.setOnClickListener(this);
        tuichu.setOnClickListener(this);
        xiugai.setOnClickListener(this);
        //信息展示
        xinxishow();
    }

    private void xinxishow() {
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        String sql="select * from user where name=?";
        Cursor cursor=db.rawQuery(sql,new String[]{WelcomeActivity.Noname});
        while(cursor.moveToNext()){
            namer=cursor.getString(cursor.getColumnIndex("name"));
            head.setImageResource(cursor.getInt(cursor.getColumnIndex("headImg")));//设置头像
            zhanghao.setText(namer);
            tel.setText(cursor.getString(cursor.getColumnIndex("tel")));
        }
    }

    @Override
    public void onClick(View v) {
       switch(v.getId()){
           case R.id.ps_fanhui://取消
               Intent intent3=new Intent(this,WodeActivity.class);
               startActivity(intent3);
               this.overridePendingTransition(R.anim.main_in2,R.anim.main_out2);
               finish();
               break;
           case R.id.ps_baocun://保存电话
               String ntel=tel.getText().toString().trim();
               String nname=zhanghao.getText().toString().trim();
               SQLiteDatabase db=mOpenHelper.getWritableDatabase();
               ContentValues contentValues=new ContentValues();
               contentValues.put("tel",ntel);
               db.update("user",contentValues,"name=?",new String[]{nname});
               db.close();
               Toast.makeText(this, "信息保存成功", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(this,WodeActivity.class);
               startActivity(intent);
               this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
               finish();
               break;
           case R.id.ps_xiugai://修改密码
               Intent intent1=new Intent(this,ChangeActivity.class);
               startActivity(intent1);
               break;
           case R.id.ps_tuichu://退出
               Intent intent2=new Intent(this,WelcomeActivity.class);
               startActivity(intent2);
               this.overridePendingTransition(R.anim.main_in1,R.anim.main_out1);
               finish();
               break;
       }
    }
}
