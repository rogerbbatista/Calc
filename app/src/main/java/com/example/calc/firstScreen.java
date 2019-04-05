package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class firstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }

    public void action(View v){
        final EditText val1 = (EditText) findViewById(R.id.val1Txt);
        final EditText val2 = (EditText) findViewById(R.id.val2Txt);
        final TextView out = (TextView) findViewById(R.id.outTxt);

        String tag = v.getTag().toString();
        Double a = Double.parseDouble(val1.getText().toString());
        Double b = Double.parseDouble(val2.getText().toString());

        Double result = 0.0;
        switch(tag){
            case "1":
                result = a + b;
                break;
            case "2":
                result = a - b;
                break;
            case "3":
                result = a * b;
                break;
            case "4":
                result = a / b;
                break;
        }
        out.setText("O Resultado é " + result);
    }

}
