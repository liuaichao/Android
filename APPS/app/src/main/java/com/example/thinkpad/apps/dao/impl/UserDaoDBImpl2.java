package com.example.thinkpad.apps.dao.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thinkpad.apps.IUserDao2;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperCheck;

import java.util.ArrayList;
import java.util.List;

public class UserDaoDBImpl2 implements IUserDao2 {
    private static UserDaoDBImpl2 userDao2;
    private static MyOpenHelperCheck myOpenHelperCheck;
    private static List<User2> users;
    private UserDaoDBImpl2(){

    }
    public static IUserDao2 getDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        myOpenHelperCheck=new MyOpenHelperCheck(context,name,factory,version);
        synchronized (String.class){
            if(userDao2==null){
                userDao2=new UserDaoDBImpl2();
            }
        }
        return userDao2;

    }


    @Override
    public void addUser(User2 user) {
        SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
        String sql="insert into user(namer,start,final,remark,time,state) values(?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{user.getNamer(),user.getStart(),user.getFina(),user.getRemark(),user.getTime(),user.getState()});

        release(db,null);

    }



    @Override
    public boolean findUserByNameAndPwd(String name, String pwd) {
        //打开数据库
        SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where name=? and pwd=?",new String[]{name,pwd});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }

    @Override
    public boolean findUserByName(String name) {
        //打开数据库
        SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where name=? ",new String[]{name});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }

    @Override
    public List<User2> showAll() {
        List<User2> users=new ArrayList<>();
        SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user",null);
        while (cursor.moveToNext()){
            User2 u=new User2();
            u.setStart(cursor.getString(cursor.getColumnIndex("start")));
            u.setFina(cursor.getString(cursor.getColumnIndex("final")));
            u.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
            u.setTime(cursor.getString(cursor.getColumnIndex("time")));
            u.setState(cursor.getString(cursor.getColumnIndex("state")));

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
        SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
        db.execSQL("delete from user where time=?",new Object[]{time});
        db.close();
    }

    @Override
    public void changetext() {

    }

}
