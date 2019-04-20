package com.example.thinkpad.shoujitxl;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import  android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
public class tianjia extends Activity {


    static  EditText editText3, editText4, editText5, editText6, editText;
    Button button3, button4;
    TextView textView7,textView14,textView15,textView19,textView16,textView17,textView18,textView20,
            textView36,textView37,textView39,textView40,textView41,textView42,textView43,textView44,textView45,
    textView46;
    Cursor cursor;
    SQLiteDatabase db;
    shujuku helper;
    public int id_this;
    Bundle savedInstanceState;
    static String TABLE_NAME="Dianhua";
    static String ID="_id";
    static String USER_NAME="user_name";
    static String TELEPHONE="telephone";
    static String FIRM="firm";
    static String POST="post";
    static String MAIL_ADDRESS="mail_address";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new lianxirn3());
        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new lianxirn3());


        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);
        editText6=(EditText)findViewById(R.id.editText6);
        editText=(EditText)findViewById(R.id.editText);

        textView39=(TextView)findViewById(R.id.textView39);
        textView40=(TextView)findViewById(R.id.textView40);
        textView41=(TextView)findViewById(R.id.textView41);
        textView43=(TextView)findViewById(R.id.textView43);
        textView44=(TextView)findViewById(R.id.textView44);
        textView45=(TextView)findViewById(R.id.textView45);
        textView42=(TextView)findViewById(R.id.textView42);
        textView46=(TextView)findViewById(R.id.textView46);
        textView7=(TextView)findViewById(R.id.textView7);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView19=(TextView)findViewById(R.id.textView19);
        textView16=(TextView)findViewById(R.id.textView16);
        textView17=(TextView)findViewById(R.id.textView17);
        textView18=(TextView)findViewById(R.id.textView18);
        textView20=(TextView)findViewById(R.id.textView20);
        textView36=(TextView)findViewById(R.id.textView36);
        textView37=(TextView)findViewById(R.id.textView37);





    }

    class  lianxirn3 implements View.OnClickListener{


        public void onClick(View v){
            helper=new shujuku(tianjia.this);
            SQLiteDatabase db=helper.getWritableDatabase();
            if (v==button4){
                ContentValues values1=new ContentValues();
                values1.put(USER_NAME,tianjia.editText3.getText().toString());
                values1.put(TELEPHONE,tianjia.editText6.getText().toString());
                values1.put(FIRM,tianjia.editText4.getText().toString());
                values1.put(POST,tianjia.editText5.getText().toString());
                values1.put(MAIL_ADDRESS,tianjia.editText.getText().toString());
                SQLiteDatabase db2=helper.getWritableDatabase();
                db2.insert(TABLE_NAME,null,values1);
                db2.close();
                id_this=Integer.parseInt(cursor.getString(0));
                String user_name_this=cursor.getString(1);
                String telephone_this=cursor.getString(2);
                String firn_this=cursor.getString(3);
                String post_this=cursor.getString(4);
                String mail_address_this=cursor.getString(5);
                switch (v.getId()) {
                    case R.id.button4:
                        if ((textView39.getText()).equals("")){
                            textView39.setText(user_name_this);break;
                        }
                        if ((textView40.getText()).equals("")){
                            textView40.setText(user_name_this);break;
                        }
                        if ((textView41.getText()).equals("")){
                            textView41.setText(user_name_this);break;
                        }
                        if ((textView42.getText()).equals("")){
                            textView42.setText(user_name_this);break;
                        }
                        if ((textView43.getText()).equals("")){
                            textView43.setText(user_name_this);break;
                        }
                        if ((textView44.getText()).equals("")){
                            textView44.setText(user_name_this);break;
                        }
                        if ((textView45.getText()).equals("")){
                            textView45.setText(user_name_this);break;
                        }
                        if ((textView46.getText()).equals("")){
                            textView46.setText(user_name_this);break;
                        }


                }
                textView36.setText(telephone_this);
                textView37.setText(mail_address_this);







                }
                if (v==button3) {
                    cursor.close();
                    Intent intent=new Intent(tianjia.this,Activity.class);

                    startActivity(intent);

                }




        }}}