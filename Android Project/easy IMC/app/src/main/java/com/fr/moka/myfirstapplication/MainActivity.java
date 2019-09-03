package com.fr.moka.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //create elements
    TextView textView;
    EditText editText;
    TextView textView2;
    EditText editText2;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton2;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        //launch
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create listener
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        //console log
        System.out.println("OnCreate Finished");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                //todo
                System.out.println("calculate processing...");
                break;
            case R.id.button2:
                editText.getText().clear();
                editText2.getText().clear();
                System.out.println("cleared fields");
                break;
        }
    }
}