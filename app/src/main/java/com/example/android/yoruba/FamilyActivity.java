package com.example.android.yoruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_family);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("father", "baba"));
        words.add (new Word ("mother", "mama"));
        words.add (new Word ("son", "omo okunrin"));
        words.add (new Word ("daughter", "omo obinrin"));
        words.add (new Word ("older brother", "egbon okunrin"));
        words.add (new Word ("younger brother", "aburo okunrin"));
        words.add (new Word ("older sister", "egon obinrin"));
        words.add (new Word ("younger sister", "aburo obinrin"));
        words.add (new Word ("grandmother", "mama mama"));
        words.add (new Word ("grandfather", "baba baba"));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter =  new WordAdapter (this, words);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById (R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(wordadapter);





    }
}
