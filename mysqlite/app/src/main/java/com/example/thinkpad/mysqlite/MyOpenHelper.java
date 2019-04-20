package com.example.thinkpad.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {


    public MyOpenHelper(Context context) {
        super(context, "person.db", null, 1);
    }

    @Override//创建数据库调用方法
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("qq","onCreate:数据库创建");
        //创建表
        sqLiteDatabase.execSQL("create table user(_id integer primary key autoincrement,name text(20),pwd text(20),tel text(20),sex text(10),headImg text(30))");
        String sql="insert into user(name,pwd,tel,sex,headImg) values(?,?,?,?,?)";
        //插入假数据
        for(int i=0;i<40;i++){
            sqLiteDatabase.execSQL(sql,new String[]{"liuaichao"+i,"123456","17861404961","男", R.drawable.img0+""});
        }

    }

    @Override//升级数据库
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
