package com.example.android.yoruba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView (R.layout.activity_main);

        //Find the view that shows the numbers category
        TextView numbers = findViewById (R.id.numbers);

        //Set a clicklistener on that view
        numbers.setOnClickListener (new OnClickListener () {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent (MainActivity.this, NumbersActivity.class);

                //Start the new activity
                startActivity (numbersIntent);


            }
        });


        //Find the view that shows the phrases category
        TextView phrases = findViewById (R.id.phrases);

        //Set a clicklistener on that view
        phrases.setOnClickListener (new OnClickListener () {

            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent (MainActivity.this, PhrasesActivity.class);

                //Start the new activity
                startActivity (phrasesIntent);


            }
        });


        //Find the view that shows the family category
        TextView family = findViewById (R.id.family);

        //Set a clicklistener on that view
        family.setOnClickListener (new OnClickListener () {

            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link familyActivity}
                Intent familyIntent = new Intent (MainActivity.this, FamilyActivity.class);

                //Start the new activity
                startActivity (familyIntent);


            }
        });


        //Find the view that shows the colours category
        TextView colors = findViewById (R.id.colors);

        //Set a clicklistener on that view
        colors.setOnClickListener (new OnClickListener () {

            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link colorsActivity}
                Intent colorsIntent = new Intent (MainActivity.this, ColorsActivity.class);

                //Start the new activity
                startActivity (colorsIntent);

            }
        });
        //Find the view that shows the daysmonths category
        TextView daysmonths = findViewById (R.id.daysmonths);

        //Set a clicklistener on that view
        daysmonths.setOnClickListener (new OnClickListener () {

            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link colorsActivity}
                Intent daysmonthsIntent = new Intent (MainActivity.this, DaysMonthsActivity.class);

                //Start the new activity
                startActivity (daysmonthsIntent);


            }

        });

    }

}
