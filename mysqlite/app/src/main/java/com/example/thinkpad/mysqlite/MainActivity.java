package com.example.thinkpad.mysqlite;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    MyOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        openHelper=new MyOpenHelper(this);
        SQLiteDatabase db=openHelper.getWritableDatabase();
        db.close();


}}
