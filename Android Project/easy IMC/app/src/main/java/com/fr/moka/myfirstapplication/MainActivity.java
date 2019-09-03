package com.fr.moka.myfirstapplication;
//EASY IMC - Simple Imc Calculator - 1.0 03/09/2019
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //create elements from the xml file
    TextView textView;
    EditText editText;
    TextView textView2;
    EditText editText2;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton2;
    Button button;
    Button button2;
    TextView textView3;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //launch
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create elements
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);
        editText2 = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView3 = findViewById(R.id.textView3);
        button3 = findViewById(R.id.button3);
        //create listener
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        //force a choice in the radiogroup
        radioButton.setChecked(true);
        //solve an issue with the color
        button3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        //console log
        System.out.println("OnCreated finished");
    }

    @Override //implemented by View.OnClickListener
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                calculate();
                System.out.println("calculate processing...");
                break;
            case R.id.button2:
                reset();
                System.out.println("cleared fields");
                break;
        }
    }

    //calculate function
    public void calculate() {
        //create variables
        boolean isMeter = radioButton.isChecked(); //&& (editText.getText().length() > 0 && editText2.length() > 0); //avoid to calculate when nothing is wrote
        String imc;
        float size = Float.valueOf(editText2.getText().toString());
        float weight = Float.valueOf(editText.getText().toString());
        //convert to meters
        if (!isMeter) { size = size/100; }
        //calculate
        DecimalFormat df = new DecimalFormat("#.##");
        float imcInd = (float) (weight/Math.pow(size, 2));
        imc = df.format(imcInd);
        //write
        button3.setText(imc);
        //colorize the imc
        imcIndicator(imcInd);
    }

    //reset function
    public void reset() {
        editText.getText().clear();
        editText2.getText().clear();
        button3.setText("");
        button3.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    //imc color indicator
    public void imcIndicator(Float value) {
        if (value > 35) { button3.setBackgroundColor(Color.parseColor("#960E0E")); }
        else if (value > 30) { button3.setBackgroundColor(Color.parseColor("#DA8C1A")); }
        else if (value > 25) { button3.setBackgroundColor(Color.parseColor("#DA8C1A")); }
        else if (value > 18.5) { button3.setBackgroundColor(Color.parseColor("#77DA1A")); }
        else { button3.setBackgroundColor(Color.parseColor("#000000")); }
    }
}