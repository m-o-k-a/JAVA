package com.fr.moka.adaptertry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Set ListView
    ListView genres;
    ListView attirances;
    //Set RadioGroup
    //TODO RadioGroup genresGroup = new RadioGroup(this);
    //TODO RadioGroup attirancesGroup = new RadioGroup(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Create listener for RadioGroup

        //will be a radiogoup with only one selection
        String[] genre = {"male", "female", "microwave", "other"};
        //will be a radiogroup with many selections
        String[] attirance = {"male", "female", "microwave", "other"};

        //initialize ListView
        genres = findViewById(R.id.listView);
        attirances = findViewById(R.id.listView2);

        //create list
        List<RadioButton> genresList = new ArrayList<>();
        List<RadioButton> attirancesList = new ArrayList<>();

        //create for each List the RadioButton and add them
        for (int i = 0; i < genre.length; i++) {
            RadioButton addButton = new RadioButton(this);
            addButton.setText(genre[i]);
            //TODO addButton.setOnClickListener(onClickListener);
            genresList.add(addButton);
            //add to radiogroup
            //TODO genresGroup.addView(addButton);
        }
        for (int i = 0; i < genre.length; i++) {
            RadioButton addButton = new RadioButton(this);
            addButton.setText(attirance[i]);
            //TODO addButton.setOnClickListener(onClickListener);
            attirancesList.add(addButton);
            //add to radiogroup
            //TODO attirancesGroup.addView(addButton);
        }

        //create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, genre);
        genres.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, attirance);
        genres.setAdapter(adapter2);

        //link the adapter with their listview
        genres.setAdapter(adapter);
        attirances.setAdapter(adapter2);
    }
}
