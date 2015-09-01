package com.example.m.design;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button button0 = (Button)findViewById(R.id.button0);
        Button buttonX = (Button)findViewById(R.id.buttonX);
        Button buttonDivide = (Button)findViewById(R.id.buttonDivide);
        Button buttonPlus = (Button)findViewById(R.id.buttonPlus);
        Button buttonMinus = (Button)findViewById(R.id.buttonMinus);
        Button buttonEquals = (Button)findViewById(R.id.buttonEquals);
        Button buttonClear = (Button)findViewById(R.id.buttonClear);
        Button buttonDot = (Button)findViewById(R.id.buttonDot);
        Button buttonCarat = (Button)findViewById(R.id.buttonCarat);
        Button buttonSin = (Button)findViewById(R.id.buttonSin);
        Button buttonCos = (Button)findViewById(R.id.buttonCos);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonX.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonCarat.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);

    }

    /*stores whatever is clicked into tempNum, when an operator is clicked, it saves tempNum
    into firstNum
     */
    String operator;
    double firstNum = 0;
    double secondNum = 0;
    double ans = 0;
    String tempNum = "0";
    /*
    checks to see if an operator is used more than once in the same calculation i.e. 3+3/7
    and if so, calculates the first two numbers automatically before applying the second operation.
    does not follow PEMDAS.

    doesn't allow carat or decimal to be used more than once.
     */
    boolean buttonUsed, dotUsed, caratUsed = false;

    @Override
    public void onClick(View v){
        TextView calcText = (TextView)findViewById(R.id.textView);

        switch(v.getId()){

            case R.id.button1:
                calcText.append("1");
                tempNum += "1";
            break;
            case R.id.button2:
                calcText.append("2");
                tempNum += "2";
            break;
            case R.id.button3:
                calcText.append("3");
                tempNum += "3";
            break;
            case R.id.button4:
                calcText.append("4");
                tempNum += "4";
            break;
            case R.id.button5:
                calcText.append("5");
                tempNum += "5";
            break;
            case R.id.button6:
                calcText.append("6");
                tempNum += "6";
            break;
            case R.id.button7:
                calcText.append("7");
                tempNum += "7";
            break;
            case R.id.button8:
                calcText.append("8");
                tempNum += "8";
            break;
            case R.id.button9:
                calcText.append("9");
                tempNum += "9";
            break;
            case R.id.button0:
                calcText.append("0");
                tempNum += "0";
            break;
            case R.id.buttonDot:
                if (!dotUsed) {
                    calcText.append(".");
                    tempNum += ".";
                    dotUsed = true;
                }
            break;

            case R.id.buttonX:
                if (buttonUsed){
                    secondNum = Double.parseDouble(tempNum);
                    double ans = doCalculations(firstNum, secondNum, operator);
                    int ansInt = (int) ans;

                    if (ans%ansInt != 0.0) {
                        calcText.setText("" + ans);
                    }
                    else {
                        calcText.setText("" + ansInt);
                    }
                    operator = "*";
                    firstNum = ans;
                    tempNum = "0";
                    buttonUsed = false;
                }
                else {
                    operator = "*";
                    firstNum = Double.parseDouble(tempNum);
                    tempNum = "0";

                }
                calcText.append("*");
                buttonUsed = true;
                dotUsed = false;
            break;
            case R.id.buttonDivide:
                if (buttonUsed){
                    secondNum = Double.parseDouble(tempNum);
                    double ans = doCalculations(firstNum, secondNum, operator);
                    int ansInt = (int) ans;
                    if (ans%ansInt != 0.0) {
                        calcText.setText("" + ans);
                    }
                    else {
                        calcText.setText("" + ansInt);
                    }
                    operator = "/";
                    firstNum = ans;
                    tempNum = "0";
                    buttonUsed = false;
                }
                else {
                    operator = "/";
                    firstNum = Double.parseDouble(tempNum);
                    tempNum = "0";

                }
                calcText.append("/");
                buttonUsed = true;
                dotUsed = false;
            break;
            case R.id.buttonPlus:
                if (buttonUsed){
                    secondNum = Double.parseDouble(tempNum);
                    double ans = doCalculations(firstNum, secondNum, operator);
                    int ansInt = (int) ans;
                    if (ans%ansInt != 0.0) {
                        calcText.setText("" + ans);
                    }
                    else {
                        calcText.setText("" + ansInt);
                    }
                    operator = "+";
                    firstNum = ans;
                    tempNum = "0";
                    buttonUsed = false;
                }
                else {
                    operator = "+";
                    firstNum = Double.parseDouble(tempNum);
                    tempNum = "";
                }
                calcText.append("+");
                buttonUsed = true;
                dotUsed = false;
            break;
            case R.id.buttonMinus:
                if (buttonUsed){
                    secondNum = Double.parseDouble(tempNum);
                    double ans = doCalculations(firstNum, secondNum, operator);
                    int ansInt = (int) ans;
                    if (ans%ansInt != 0.0) {
                        calcText.setText("" + ans);
                    }
                    else {
                        calcText.setText("" + ansInt);
                    }
                    operator = "-";
                    firstNum = ans;
                    tempNum = "0";
                    buttonUsed = false;
                }
                else {
                    operator = "-";
                    firstNum = Double.parseDouble(tempNum);
                    tempNum = "0";
                }
                calcText.append("-");
                buttonUsed = true;
                dotUsed = false;
            break;
            case R.id.buttonCarat:

                if (!caratUsed) {
                    firstNum = Double.parseDouble(tempNum);
                    tempNum = "0";
                    calcText.append("^");
                    operator = "^";
                    caratUsed = true;
                }
            break;
            case R.id.buttonClear:
                calcText.setText("");
                firstNum = 0;
                secondNum = 0;
                tempNum = "0";
                operator = "";
                dotUsed = false;
                caratUsed = false;
            break;
            case R.id.buttonSin:
                calcText.setText("Sin(");
                operator = "sin";
            break;
            case R.id.buttonCos:
                calcText.setText("Cos(");
                operator = "cos";
            break;
            //stores what is currently on screen into secondNum, performs operation, then clears everything.
            case R.id.buttonEquals:
                secondNum = Double.parseDouble(tempNum);
                calcText.setText(operator);
                double ans = doCalculations(firstNum, secondNum, operator);
                int ansInt = (int) ans;
                if (ans%ansInt != 0){
                    calcText.setText("" + ans);
                }
                else {
                    calcText.setText("" + ansInt);
                }
                tempNum = "" + ans;
                firstNum = 0;
                secondNum = 0;
                operator = "";
                buttonUsed = false;
                dotUsed = false;
                caratUsed = false;
                break;
            default:
            break;

        }
    }


    public double doCalculations(double firstNum, double secondNum, String operator){
        double ans = 0;

        switch (operator){
            case "*":
                ans = firstNum*secondNum;
                break;
            case "/":
                ans = firstNum/secondNum;
                break;
            case "+":
                ans = firstNum+secondNum;
                break;
            case "-":
                ans = firstNum-secondNum;
                break;
            case "^":
                ans = Math.pow(firstNum, secondNum);
                break;
            case "sin":
                ans = Math.sin(Math.toRadians(secondNum));
                break;
            case "cos":
                ans = Math.cos(Math.toRadians(secondNum));
                break;
            default:
                break;
        }

        return ans;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
