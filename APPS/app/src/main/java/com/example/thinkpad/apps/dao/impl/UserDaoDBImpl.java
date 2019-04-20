package com.example.thinkpad.apps.dao.impl;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.utils.MyOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDaoDBImpl implements IUserDao {
    private static UserDaoDBImpl userDao;
    private static MyOpenHelper mOpenHelper;
    private UserDaoDBImpl(){

    }
    public static IUserDao getDao(Activity activity){
        mOpenHelper=new MyOpenHelper(activity);
        synchronized (String.class){
           if(userDao==null){
               userDao=new UserDaoDBImpl();
           }
       }
        return userDao;

    }


    @Override
    public void addUser(User user) {
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        String sql="insert into user(name,pwd,tel,sex,headImg) values(?,?,?,?,?)";
        db.execSQL(sql,new Object[]{user.getName(),user.getPwd(),user.gettel(),user.getsex(),user.getHeadImg()});

        release(db,null);

    }

    @Override
    public boolean findUserByNameAndPwd(String name, String pwd) {
        //打开数据库
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
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
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where name=? ",new String[]{name});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }

    @Override
    public List<User> showAll() {
        List<User> users=new ArrayList<>();
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user",null);
        while (cursor.moveToNext()){
            User u=new User();
            u.setName(cursor.getString(cursor.getColumnIndex("name")));
            u.setPwd(cursor.getString(cursor.getColumnIndex("pwd")));
            u.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            u.setTel(cursor.getString(cursor.getColumnIndex("tel")));
            u.setHeadImg(Integer.parseInt(cursor.getString(cursor.getColumnIndex("headImg"))));
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
    public void delUser(String name) {
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        db.execSQL("delete from user where name=?",new Object[]{name});
        db.close();
    }

    @Override
    public boolean findUserPwd(String pwd) {
        //打开数据库
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user where pwd=?",new String[]{pwd});

        if (cursor.moveToNext()){
            release(db,cursor);
            return true;
        }
        release(db,cursor);
        return false;
    }
}
