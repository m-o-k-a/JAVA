package com.fr.moka.easynotes;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    //xml content
    //HTML BALISES BUTTON
    ConstraintLayout layout;
    TableLayout layout2;
    TextView styles;
    TextView colors;
    TextView edit;
    Button toB; //bold
    Button toI; //Italique
    Button toU; //Underline
    Button colorBrown; //change color to black
    Button colorSaddlebrown; //change color to red
    Button colorGoldenrod; //change color to yellow
    //EDITTEXTZONE
    EditText preview;
    //TEXTZONE
    TextView text;

    //menu state variables
    boolean isSylesOpen;
    boolean isColorOpen;
    boolean isEditOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set variables
        layout = findViewById(R.id.layout);
        layout2 = findViewById(R.id.layout2);
        styles = findViewById(R.id.styles);
        colors = findViewById(R.id.colors);
        edit = findViewById(R.id.edit);
        toB = findViewById(R.id.toB);
        toI = findViewById(R.id.toI);
        toU = findViewById(R.id.toU);
        colorBrown = findViewById(R.id.colorBrown);
        colorGoldenrod = findViewById(R.id.colorGoldenrod);
        colorSaddlebrown = findViewById(R.id.colorSaddlebrown);
        preview = findViewById(R.id.preview);
        text = findViewById(R.id.text);
        isSylesOpen = false;
        isColorOpen = false;
        isEditOpen = true;
        edit.setTextColor(Color.parseColor("#800000"));

        //touch screen to update
        //Very not optimized indeed
        layout.setOnTouchListener(this);
        layout2.setOnTouchListener(this);
        text.setOnTouchListener(this);

    }

    //Command
    public void openStyles(View v) {
        if (isSylesOpen) {
            isSylesOpen = false;
            toB.setVisibility(View.GONE);
            toU.setVisibility(View.GONE);
            toI.setVisibility(View.GONE);
            styles.setTextColor(Color.parseColor("#D2691E"));
        }
        else {
            isSylesOpen = true;
            toB.setVisibility(View.VISIBLE);
            toI.setVisibility(View.VISIBLE);
            toU.setVisibility(View.VISIBLE);
            styles.setTextColor(Color.parseColor("#800000"));
        }
    }
    public void openColors(View v) {
        if (isColorOpen) {
            isColorOpen = false;
            colorBrown.setVisibility(View.GONE);
            colorSaddlebrown.setVisibility(View.GONE);
            colorGoldenrod.setVisibility(View.GONE);
            colors.setTextColor(Color.parseColor("#D2691E"));
        }
        else {
            isColorOpen = true;
            colorBrown.setVisibility(View.VISIBLE);
            colorSaddlebrown.setVisibility(View.VISIBLE);
            colorGoldenrod.setVisibility(View.VISIBLE);
            colors.setTextColor(Color.parseColor("#800000"));
        }
    }
    public void openEdit(View v) {
        if (isEditOpen) {
            isEditOpen = false;
            preview.setVisibility(View.GONE);
            edit.setTextColor(Color.parseColor("#D2691E"));
        }
        else {
            isEditOpen = true;
            preview.setVisibility(View.VISIBLE);
            edit.setTextColor(Color.parseColor("#800000"));
        }
    }

    //styles buttons
    public void makeBold(View v) { preview.getText().append("<b></b>"); }
    public void makeItalic(View v) { preview.getText().append("<i></i>"); }
    public void makeUnderline(View v) { preview.getText().append("<u></u>"); }
    //color buttons
    public void makeBrown(View v) { preview.getText().append("<font color=\"#A52A2A\"></font>"); }
    public void makeSaddlebrown(View v) { preview.getText().append("<font color=\"#8B4513\"></font>"); }
    public void makeGoldenrod(View v) { preview.getText().append("<font color=\"#DAA520\"></font>"); }

    //update to the text
    public void update(View v) {
        String textTemp = String.valueOf(preview.getText());
        text.setText(Html.fromHtml(textTemp));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        update(view);
        return true;
    }
}
