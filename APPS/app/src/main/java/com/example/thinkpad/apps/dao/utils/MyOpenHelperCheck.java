package com.example.thinkpad.apps.dao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.thinkpad.apps.R;

public class MyOpenHelperCheck extends SQLiteOpenHelper {

    public MyOpenHelperCheck(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建表
        sqLiteDatabase.execSQL("create table user(_id integer primary key autoincrement,namer text(20),start text(20),final text(20)," +
                "remark text(40),time text(30),state text(20))");
        String sql="insert into user(namer,start,final,remark,time,state) values(?,?,?,?,?,?)";
        for(int i=0;i<40;i++){
            sqLiteDatabase.execSQL(sql,new String[]{"liuaichao1"+i,"济南","寿光","很好","2018.3.4"+i,"未接单"+""});
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
