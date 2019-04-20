package com.example.thinkpad.jiafajsq;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {


        private EditText firstNumberEditText;
        private EditText secondNumberEditText;
        private Button calculateButton;
        private TextView resulTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            firstNumberEditText = (EditText) super.findViewById(R.id.first_number);
            secondNumberEditText = (EditText) super.findViewById(R.id.second_number);
            calculateButton = (Button) super.findViewById(R.id.calculate_button);
            resulTextView = (TextView) super.findViewById(R.id.result_textview);
            calculateButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    String firstNumberString = firstNumberEditText.getText().toString();
                    String secondNumberString = secondNumberEditText.getText().toString();



                    if((!firstNumberString.equals(""))&&(!secondNumberString.equals(""))){
                        int firstNumberInt = Integer.parseInt(firstNumberString);
                        int secondNumberInt = Integer.parseInt(secondNumberString);
                        int resultint= firstNumberInt+secondNumberInt;
                        resulTextView.setText(resultint+"");
                    }else{
                        Toast.makeText(MainActivity.this, "请将数字填完整", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

