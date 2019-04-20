package com.example.thinkpad.apps.dao.impl;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thinkpad.apps.IUserDao2;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.IUserDao3;
import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.entity.User3;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperCheck;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperPao;

import java.util.ArrayList;
import java.util.List;

public class UserDaoDBImpl3 implements IUserDao3 {
    private static UserDaoDBImpl3 userDao3;
    private static MyOpenHelperPao myOpenHelperPao;
    private static List<User3> users;
    private UserDaoDBImpl3(){

    }
    public static IUserDao3 getDao(Activity activity){
        myOpenHelperPao=new MyOpenHelperPao(activity);
        synchronized (String.class){
            if(userDao3==null){
                userDao3=new UserDaoDBImpl3();
            }
        }
        return userDao3;

    }

    public void addUser(User3 user) {
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        String sql="insert into user(namer,start,final,remark,time,state,tel) values(?,?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{user.getNamer(),user.getStart(),user.getFina(),user.getRemark(),user.getTime(),user.getState(),user.getTel()});

        release(db,null);

    }

    @Override
    public boolean findUserByNameAndPwd(String name, String pwd) {
        //打开数据库
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where name=? and pwd=?",new String[]{name,pwd});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }

    @Override
    public boolean findUserByName(String time) {
        //打开数据库
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where time=? ",new String[]{time});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }

    @Override
    public List<User3> showAll() {
        List<User3> users=new ArrayList<>();
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user",null);
        while (cursor.moveToNext()){
            User3 u=new User3();
            u.setStart(cursor.getString(cursor.getColumnIndex("start")));
            u.setFina(cursor.getString(cursor.getColumnIndex("final")));
            u.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
            u.setTime(cursor.getString(cursor.getColumnIndex("time")));
            u.setState(cursor.getString(cursor.getColumnIndex("state")));
            u.setTel(cursor.getString(cursor.getColumnIndex("tel")));

            users.add(u);
        }
        release(db,cursor);
        return users;
    }

    @Override
    public void release(SQLiteDatabase db, Cursor cursor) {
        if(db!=null){
            db.close();
        }
        if(cursor!=null){
            cursor.close();
        }
    }

    @Override
    public void delUser(String time) {
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        db.execSQL("delete from user where time=?",new Object[]{time});
        db.close();
    }

    @Override
    public void changetext() {

    }

    @Override
    public String select(String time) {
        String tel;
        tel="";
        SQLiteDatabase db=myOpenHelperPao.getWritableDatabase();
        String sql="select * from user where time=?";
        Cursor cursor=db.rawQuery(sql,new String[]{time});
        while (cursor.moveToNext()){
            tel=cursor.getString(cursor.getColumnIndex("tel"));
        }
        return tel;
    }

}

