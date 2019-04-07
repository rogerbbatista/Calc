package com.example.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class secondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        final EditText content = (EditText) findViewById(R.id.content);
        content.setInputType(0);
    }

    boolean equalPressed = false;

    public void action(View v){
        final EditText content = (EditText) findViewById(R.id.content);

        String sentence = content.getText().toString();
        if (v.getTag().toString().matches("\\s[\\*\\/\\+\\-]\\s")) {
            if (sentence.length() == 0) return;
            if (sentence.substring(sentence.length()-1).compareTo(" ") == 0){
                sentence = sentence.substring(0, sentence.length()-3);
            }
        }else if (v.getTag().toString().matches("\\.")) {
            int lastSpace = (sentence.lastIndexOf(' ') > 0) ? sentence.lastIndexOf(' ') : 0;
            if (sentence.indexOf('.', lastSpace) > 0) return;
        }
        if (equalPressed){
            if (v.getTag().toString().matches("[0-9]"))sentence = "";
            equalPressed = false;
        }
        content.setText(sentence + v.getTag().toString());
    }

    public void clear(View v){
        final EditText content = (EditText) findViewById(R.id.content);

        content.setText("");
    }

    public void delete (View v){
        final EditText content = (EditText) findViewById(R.id.content);

        String sentence = content.getText().toString();
        if (sentence.length() != 0)
        if (sentence.substring(sentence.length()-1).matches("[0-9]") ) content.setText(sentence.substring(0, sentence.length()-1));
        else if (sentence.substring(sentence.length()-1).matches("\\.") ){
            content.setText(sentence.substring(0, sentence.length()-1));
        } else content.setText(sentence.substring(0, sentence.length()-3));
    }

    public void equal (View v){
        final EditText content = (EditText) findViewById(R.id.content);
        String sentence = content.getText().toString();

        String removeSpace = sentence.replace(" ", "");
        String[] ops = removeSpace.split("[0-9\\.]+");
        String[] aux = removeSpace.split("[\\*\\/\\+\\-]");
        double[] num = new double[aux.length];
        for (int i = 0; i < aux.length; i++){
            num[i] = Double.parseDouble(aux[i]);
        }

        Double result = num[0];
        for (int i = 0; i < ops.length; i++){
            switch (ops[i]){
                case "+":
                    result += num[i];
                    break;
                case "-":
                    result -= num[i];
                    break;
                case "/":
                    result /= num[i];
                    break;
                case "*":
                    result *= num[i];
                    break;
            }
        }

        equalPressed = true;
        DecimalFormat dec = new DecimalFormat("#0.00");
        content.setText(""+dec.format(result));
    }

    public void calc1(View v){
        Intent it = new Intent(this, firstScreen.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(it);
    }
}
