package com.example.thinkpad.apps.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.entity.User3;

import java.util.List;

public interface IUserDao3 {
    //添加用户   注册时用
    void addUser(User3 user);
    //查找指定用户  根据用户名和密码去查找  登陆时用
    boolean findUserByNameAndPwd(String name,String pwd);
    //用户名查重  注册时
    boolean findUserByName(String name);
    //显示所有用户  登陆成功
    List<User3> showAll();
    //释放数据库资源
    void release(SQLiteDatabase db, Cursor cursor);
    //删除指定条目用户
    void delUser(String name);
    void changetext();
    String select(String time);
}


