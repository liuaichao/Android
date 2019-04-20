package com.example.thinkpad.apps.dao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelperPao extends SQLiteOpenHelper {

    public MyOpenHelperPao(Context context) {
        super(context,"add.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建表
        sqLiteDatabase.execSQL("create table user(_id integer primary key autoincrement,namer text(20),start text(20),final text(20)," +
                "remark text(40),time text(30),state text(20),tel text(20))");
        String sql="insert into user(namer,start,final,remark,time,state,tel) values(?,?,?,?,?,?,?)";
        for(int i=0;i<40;i++){
            sqLiteDatabase.execSQL(sql,new String[]{"liuaichao1"+i,"济南","寿光","很好","2018.3.4"+i,"未接单","17861404961"+i+""});
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
