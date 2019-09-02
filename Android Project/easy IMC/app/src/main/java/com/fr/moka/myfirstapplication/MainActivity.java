package com.fr.moka.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create elements
        TextView textView = new TextView(this);
        EditText editText = new EditText(this);
        TextView textview2 = new TextView(this);
        EditText editText2 = new EditText(this);
        //TODO radiogroup
        Button button = new Button(this);
        Button button2 = new Button(this);
    }
}
