package com.example.thinkpad.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends SQLiteOpenHelper
{
   static final String Database_name="Zhuce.dp";
   static final int Database_Version=1;
   SQLiteDatabase dp;
   public int id_this;
   Cursor cursor;
   static String TABLE_NAME="Users";
   static String ID="_id";
   static String PASSWORD="password";
   static String USER_NAME="user_name";
   static String TELEPHONE="telephone";
   static String MAIL_ADDRESS="mail_address";
   MainActivity(Context ctx)



   {
      super(ctx,Database_name,null,Database_Version);
   }
   public void onCreate(SQLiteDatabase database){
      String sql="CREATE TABLE "+TABLE_NAME+"("+ID+"INTEGER primary key autoincrement,"+USER_NAME+"text not null,"
              +TELEPHONE+"text not null,"+PASSWORD+"text not null,"+MAIL_ADDRESS+"text not null,"+");";
      database.execSQL(sql);

   }
   public void onUpgrade(SQLiteDatabase dp,int oldVersion,int newVersion){}
}