package com.example.thinkpad.shoujitxl;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



// 计算器
public class jisuanqi extends AppCompatActivity implements View.OnClickListener{
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;

    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;

    private Button dot_btn;
    private Button percent_btn;
    private Button delete_btn;
    private Button ac_btn;

    private EditText mResultText;

    private String existedText = "";

    private boolean isCounted = false;

    private boolean startWithOperator = false;

    private boolean startWithSubtract = false;

    private boolean noStartWithOperator = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jisuanqi);
        initView();
        initEvent();
    }
    private void initView() {

        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);

        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);

        dot_btn = (Button) findViewById(R.id.dot_btn);
        percent_btn = (Button) findViewById(R.id.percent_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        mResultText = (EditText) findViewById(R.id.result_text);
        existedText = mResultText.getText().toString();

    }

    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);

        dot_btn.setOnClickListener(this);
        percent_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.num_zero:
                existedText = isOverRange(existedText,"0");
                break;
            case R.id.num_one:
                existedText = isOverRange(existedText,"1");
                break;
            case R.id.num_two:
                existedText = isOverRange(existedText,"2");
                break;
            case R.id.num_three:
                existedText = isOverRange(existedText,"3");
                break;
            case R.id.num_four:
                existedText = isOverRange(existedText,"4");
                break;
            case R.id.num_five:
                existedText = isOverRange(existedText,"5");
                break;
            case R.id.num_six:
                existedText = isOverRange(existedText,"6");
                break;
            case R.id.num_seven:
                existedText = isOverRange(existedText,"7");
                break;
            case R.id.num_eight:
                existedText = isOverRange(existedText,"8");
                break;
            case R.id.num_nine:
                existedText = isOverRange(existedText,"9");
                break;
            case R.id.plus_btn:
                if (!existedText.contains("e")) {

                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "+";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "+");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText += "+";
                        }
                    }
                } else {
                    existedText = "0";
                }

                break;
            case R.id.subtract_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "-";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "-");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText += "-";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.multiply_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "×";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "×");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText += "×";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.divide_btn:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")){

                        } else {
                            existedText += "÷";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "÷");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText += "÷";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.equal_btn:
                existedText = getResult();
                isCounted = true;
                break;

            case R.id.dot_btn:

                if (!isCounted){

                    if (existedText.contains("+") || existedText.contains("-") ||
                            existedText.contains("×") || existedText.contains("÷") ){

                        String param1 = null;
                        String param2 = null;

                        if (existedText.contains("+")) {
                            param1 = existedText.substring(0, existedText.indexOf("+"));
                            param2 = existedText.substring(existedText.indexOf("+") + 1);
                        } else if (existedText.contains("-")) {
                            param1 = existedText.substring(0, existedText.indexOf("-"));
                            param2 = existedText.substring(existedText.indexOf("-") + 1);
                        } else if (existedText.contains("×")) {
                            param1 = existedText.substring(0, existedText.indexOf("×"));
                            param2 = existedText.substring(existedText.indexOf("×") + 1);
                        } else if (existedText.contains("÷")) {
                            param1 = existedText.substring(0, existedText.indexOf("÷"));
                            param2 = existedText.substring(existedText.indexOf("÷") + 1);
                        }
                        Log.d("Anonymous param1",param1);
                        Log.d("Anonymous param2",param2);

                        boolean isContainedDot = param2.contains(".");
                        if (param2.length() >= 9){

                        } else if (!isContainedDot){
                            if (param2.equals("")){
                                existedText += "0.";
                            } else {
                                existedText += ".";
                            }
                        } else {
                            return;
                        }
                    } else {
                        boolean isContainedDot = existedText.contains(".");
                        if (existedText.length() >= 9){

                        } else if (!isContainedDot){
                            existedText += ".";
                        } else {
                            return;
                        }
                    }
                    isCounted = false;

                } else {
                    existedText = "0.";
                    isCounted = false;
                }


                break;
            case R.id.percent_btn:
                if (existedText.equals("error")){

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = temp / 100;
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.delete_btn:
                if (existedText.equals("error")){
                    existedText = "0";
                } else if (existedText.length() > 0){
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0,existedText.length()-1);
                    }
                }
                break;
            case R.id.ac_btn:
                existedText = "0";
                break;
        }
        mResultText.setText(existedText);
    }
    private String getResult() {
        String tempResult = null;
        String param1 = null;
        String param2 = null;
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;

        getCondition();
        if ( startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {
                param1 = existedText.substring(0, existedText.indexOf("+"));
                param2 = existedText.substring(existedText.indexOf("+") + 1);
                if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }
            } else if (existedText.contains("×")) {

                param1 = existedText.substring(0, existedText.indexOf("×"));
                param2 = existedText.substring(existedText.indexOf("×") + 1);

                if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 * arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("÷")) {

                param1 = existedText.substring(0, existedText.indexOf("÷"));
                param2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (param2.equals("0")){
                    tempResult = "error";
                } else if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 / arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("-")) {
                param1 = existedText.substring(0, existedText.lastIndexOf("-"));
                param2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (param2.equals("")){
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 - arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            }
            if (tempResult.length() >= 10) {
                tempResult = String.format("%e", Double.parseDouble(tempResult));
            } else if (tempResult.contains(".")) {
                if (tempResult.substring(0, tempResult.indexOf(".")).length() >= 10) {
                    tempResult = String.format("%e", Double.parseDouble(tempResult));
                }
            }
        } else {
            tempResult = existedText;
        }

        return tempResult;
    }

    private String isOverRange(String existedText, String s) {
        if (!isCounted){
            if (existedText.contains("e")){
                existedText = "0";
            }
            if (existedText.equals("0")){
                existedText = "";
            }
            if (existedText.contains("+") || existedText.contains("-") ||
                    existedText.contains("×") || existedText.contains("÷")){
                String param2 = null;
                if (existedText.contains("+")){
                    param2 = existedText.substring(existedText.indexOf("+")+1);
                } else if (existedText.contains("-")){
                    param2 = existedText.substring(existedText.indexOf("-")+1);
                } else if (existedText.contains("×")){
                    param2 = existedText.substring(existedText.indexOf("×")+1);
                } else if (existedText.contains("÷")){
                    param2 = existedText.substring(existedText.indexOf("÷")+1);
                }

                if (existedText.substring(existedText.length()-1).equals("+") ||
                        existedText.substring(existedText.length()-1).equals("-") ||
                        existedText.substring(existedText.length()-1).equals("×") ||
                        existedText.substring(existedText.length()-1).equals("÷")){
                    existedText += s;
                } else {
                    if (param2.contains(".")){
                        if (param2.length() >= 10){

                        } else {
                            existedText += s;
                        }
                    } else {
                        if (param2.length() >= 9){

                        } else {
                            existedText += s;
                        }
                    }
                }
            } else {

                if (existedText.contains(".")){
                    if (existedText.length() >= 10){

                    } else {
                        existedText += s;
                    }
                } else {
                    if (existedText.length() >= 9){

                    } else {
                        existedText += s;
                    }
                }
            }

            isCounted = false;

        } else {

            existedText = s;
            isCounted = false;

        }


        return existedText;
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }

    private boolean judgeExpression() {

        getCondition();

        String tempParam2 = null;

        if ( startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {
                tempParam2 = existedText.substring(existedText.indexOf("+") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            } else if (existedText.contains("×")) {

                tempParam2 = existedText.substring(existedText.indexOf("×") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("÷")) {

                tempParam2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("-")) {

                tempParam2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            }
        }
        return false;
    }

    private void getCondition() {
        startWithOperator = existedText.startsWith("-") && ( existedText.contains("+") ||
                existedText.contains("×") || existedText.contains("÷") );
        startWithSubtract = existedText.startsWith("-") && ( existedText.lastIndexOf("-") != 0 );
        noStartWithOperator = !existedText.startsWith("-") && ( existedText.contains("+") ||
                existedText.contains("-") || existedText.contains("×") || existedText.contains("÷"));
    }

}
