package com.example.thinkpad.shoujitxl;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class lxr extends Activity{
     Button button14,button15,button16,button17,button18,button19,button20,button21;
     TextView textView7,textView14,textView15,textView19,textView16,textView17,textView18,textView20,
                        textView36;
     ImageButton imageButton6,imageButton8,imageButton10,imageButton11,imageButton12,imageButton18,imageButton19,
                   imageButton20;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xianxirn);

        button14=(Button)findViewById(R.id.button14);
        button14.setOnClickListener(new lianxirn());

        button15=(Button)findViewById(R.id.button15);
        button15.setOnClickListener(new lianxirn());

        button16=(Button)findViewById(R.id.button16);
        button16.setOnClickListener(new lianxirn());

        button17=(Button)findViewById(R.id.button17);
        button17.setOnClickListener(new lianxirn());

        button18=(Button)findViewById(R.id.button18);
        button18.setOnClickListener(new lianxirn());

        button19=(Button)findViewById(R.id.button19);
        button19.setOnClickListener(new lianxirn());

        button20=(Button)findViewById(R.id.button20);
        button20.setOnClickListener(new lianxirn());

        button21=(Button)findViewById(R.id.button21);
        button21.setOnClickListener(new lianxirn());


        textView7=(TextView)findViewById(R.id.textView7);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView19=(TextView)findViewById(R.id.textView19);
        textView16=(TextView)findViewById(R.id.textView16);
        textView17=(TextView)findViewById(R.id.textView17);
        textView18=(TextView)findViewById(R.id.textView18);
        textView20=(TextView)findViewById(R.id.textView20);
        textView36=(TextView)findViewById(R.id.textView36);

        imageButton6=(ImageButton)findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new lianxirn());

        imageButton8=(ImageButton)findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new lianxirn());

        imageButton10=(ImageButton)findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new lianxirn());

        imageButton11=(ImageButton)findViewById(R.id.imageButton11);
        imageButton11.setOnClickListener(new lianxirn());

        imageButton12=(ImageButton)findViewById(R.id.imageButton12);
        imageButton12.setOnClickListener(new lianxirn());

        imageButton18=(ImageButton)findViewById(R.id.imageButton18);
        imageButton18.setOnClickListener(new lianxirn());

        imageButton19=(ImageButton)findViewById(R.id.imageButton19);
        imageButton19.setOnClickListener(new lianxirn());

        imageButton20=(ImageButton)findViewById(R.id.imageButton20);
        imageButton20.setOnClickListener(new lianxirn());







}
class  lianxirn implements View.OnClickListener{

        public void onClick(View v){
            if(v==button14) {

                if ((textView14.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                     startActivity(intent);
                     String a = textView14.getText().toString();
                     textView7.setText(a);}
            }
            if(v==button15) {

                if ((textView15.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView15.getText().toString();
                    textView7.setText(a);}
            }
            if(v==button16) {

                if ((textView16.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView16.getText().toString();
                    textView7.setText(a);}
            }
            if(v==button17) {

                if ((textView17.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView17.getText().toString();
                    textView7.setText(a);}
            }
            if(v==button18) {

                if ((textView18.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView18.getText().toString();
                    textView7.setText(a);}
            }
            if(v==button19) {

                if ((textView19.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView19.getText().toString();
                    textView7.setText(a);}
            }
            if(v==button20) {

                if ((textView20.getText()).equals("")) ;

                else{
                    Intent intent=new Intent(lxr.this,chakan.class);
                    startActivity(intent);
                    String a = textView20.getText().toString();
                    textView7.setText(a);}
            }






            //imagebutton响应
            if(v==imageButton6){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                    }}

            if(v==imageButton8){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton10){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton11){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton12){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton18){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton19){
                if ((textView20.getText()).equals("")) ;
                else {
                    String b = textView36.getText().toString();
                    Uri uri = Uri.parse("tel:b");
                    Intent it=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                }}
            if(v==imageButton20){
                Intent intent=new Intent(lxr.this,tianjia.class);
                startActivity(intent);

                }
               if(v==button21) {
                   Intent intent = new Intent(lxr.this, zhujiemian.class);
                   startActivity(intent);
               }

















            }





        }


}




