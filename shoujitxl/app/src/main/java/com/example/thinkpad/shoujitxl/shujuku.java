package com.example.thinkpad.shoujitxl;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import  android.database.sqlite.SQLiteDatabase;
import android.content.Context;
public class shujuku extends SQLiteOpenHelper{

    static final String Database_name="phoneBook.db";
    static final int Database_Version=1;
    SQLiteDatabase db;
    public int id_this;
    Cursor cursor;
       static String TABLE_NAME="Users";
       static String ID="_id";
       static String USER_NAME="user_name";
       static String TELEPHONE="telephone";
       static String FIRM="firm";
       static String POST="post";
       static String MAIL_ADDRESS="mail_address";

       shujuku(Context ctx){


           super(ctx,Database_name,null,Database_Version);
       }
       public void onCreate(SQLiteDatabase  database) {
           String sql = "CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER primary key autoincrement,"
                   + USER_NAME + "text not null," + TELEPHONE + "text not null," + FIRM + "text not null," +
                   POST + "text not null ," + MAIL_ADDRESS + " text not null " +  ");";
           database.execSQL(sql);
       }
       public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {

       }







       }


















