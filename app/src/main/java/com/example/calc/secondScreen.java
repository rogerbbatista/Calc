package com.example.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class secondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        final EditText content = (EditText) findViewById(R.id.content);
        content.setInputType(0);
    }

    public void action(View v){
        final EditText content = (EditText) findViewById(R.id.content);

        content.setText(content.getText() + v.getTag().toString());
    }

    public void clear(View v){
        final EditText content = (EditText) findViewById(R.id.content);

        content.setText("");
    }

    public void delete (View v){
        final EditText content = (EditText) findViewById(R.id.content);

        String sentence = content.getText().toString();
        if (sentence.length() != 0)
        if (sentence.substring(sentence.length()-1).matches("[0-9\\.]") ) content.setText(sentence.substring(0, sentence.length()-1));
        else content.setText(sentence.substring(0, sentence.length()-3));
    }

    public void equal (View v){
        final EditText content = (EditText) findViewById(R.id.content);
        String sentence = content.getText().toString();

        String removeSpace = sentence.replace(" ", "");
        String[] ops = removeSpace.split("[0-9\\.]+");
        String[] aux = removeSpace.split("\\*|\\/|\\+|\\-");
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

        content.setText(""+result);
    }

    public void calc1(View v){
        Intent it = new Intent(this, firstScreen.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(it);
    }
}
