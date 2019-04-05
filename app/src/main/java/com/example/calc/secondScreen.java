package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        if (sentence.length() != 0) content.setText(sentence.substring(0, sentence.length()-1));
    }

    public void equal (View v){
        final EditText content = (EditText) findViewById(R.id.content);
        String sentence = content.getText().toString();

        String removeSpace = sentence.replace(" ", "");
        String[] ops = removeSpace.split("[0-9\\.]+");
        String[] aux = removeSpace.split("\\*|\\|\\+|\\-");
        double[] num = new double[aux.length];
        for (int i = 0; i < aux.length; i++){
            num[i] = Double.parseDouble(aux[i]);
        }

        Double result;
    }
}
