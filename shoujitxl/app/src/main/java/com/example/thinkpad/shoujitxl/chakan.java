package com.example.thinkpad.shoujitxl;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
public class chakan extends Activity{


    Button button14,button15,button16,button17,button18,button19,button20,button21,button,button22;
    TextView textView7,textView14,textView15,textView19,textView16,textView17,textView18,textView20,
            textView36,textView37;
    ImageButton imageButton6,imageButton8,imageButton10,imageButton11,imageButton12,imageButton18,imageButton19,
            imageButton20,imageButton2,imageButton4,imageButton5,imageButton7,imageButton9;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lianmp);
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


        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new xiangying());
        button22=(Button)findViewById(R.id.button22);
        button22.setOnClickListener(new xiangying());

        imageButton2=(ImageButton)findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new xiangying());

        imageButton4=(ImageButton)findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new xiangying());

        imageButton5=(ImageButton)findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new xiangying());

        imageButton7=(ImageButton)findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new xiangying());

        imageButton9=(ImageButton)findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(new xiangying());








}
  class xiangying implements View.OnClickListener{

      public void onClick(View v){
          if(v==button){
              Intent intent=new Intent(chakan.this,lxr.class);
              startActivity(intent);
          }
          if(v==imageButton2){

          }
          if (v==imageButton4){

          }
          if (v==imageButton5){

          }
          if (v==imageButton7){
              String c = textView36.getText().toString();
              Uri uri = Uri.parse("tel:b");
              Intent it=new Intent(Intent.ACTION_DIAL,uri);
              startActivity(it);
              }

          if(v==imageButton9){
              String d = textView36.getText().toString();
              Uri uri = Uri.parse("smsto:d");
              Intent it=new Intent(Intent.ACTION_SENDTO,uri);
              startActivity(it);
          }
         if(v==button22){
             Intent intent=new Intent(chakan.this,lxr.class);
             startActivity(intent);


         }






      }

}}