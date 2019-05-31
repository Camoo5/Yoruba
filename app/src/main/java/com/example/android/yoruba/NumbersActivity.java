package com.example.android.yoruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);


        //Create an Arraylist of words objects
        ArrayList<Word> words = new ArrayList <Word>();
        words.add (new Word("one","okan"));
        words.add (new Word("two","meji"));
        words.add (new Word("three","mẹta"));
        words.add (new Word("four","mẹrin"));
        words.add (new Word("five","marun"));
        words.add (new Word("six","mefa"));
        words.add (new Word("seven","meje"));
        words.add (new Word("eight","mẹsan"));
        words.add (new Word("nine","mẹsan"));
        words.add (new Word("ten","mẹwàá"));

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

