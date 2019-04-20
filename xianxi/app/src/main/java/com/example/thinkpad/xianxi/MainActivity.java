package com.example.thinkpad.xianxi;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {


    WebView webView;
    Button openWebBtn;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       openWebBtn=(Button)findViewById(R.id.button);
       edit=(EditText)findViewById(R.id.editText);
       openWebBtn.setOnClickListener(new mClick());

    }
    class mClick implements View.OnClickListener
    {

        public void onClick(View arg0){

            String url=edit.getText().toString();
            webView=(WebView)findViewById(R.id.webView1);
            webView.loadUrl("http://"+url);
        }
    }
}
