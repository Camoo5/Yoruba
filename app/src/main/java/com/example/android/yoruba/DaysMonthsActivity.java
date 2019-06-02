package com.example.android.yoruba;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class DaysMonthsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);


        //Create an Arraylist of words objects
        final ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("monday", "ojọ́ ajé", 0));
        words.add (new Word ("tuesday", "ojọ́ iségun", 0));
        words.add (new Word ("wednesday", "ojọ́ ‘rú", 0));
        words.add (new Word ("thursday", "ojọ́ bo", 0));
        words.add (new Word ("friday", " ojọ́ eti", 0));
        words.add (new Word ("saturday", "ojọ́ abameta", 0));
        words.add (new Word ("sunday", "ojọ́ aiku", 0));
        words.add (new Word ("january", "seere", 0));
        words.add (new Word ("february", "erele", 0));
        words.add (new Word ("march", "erénà", 0));
        words.add (new Word ("april", "igbe", 0));
        words.add (new Word ("may", "ebìbí", 0));
        words.add (new Word ("june", "okudu", 0));
        words.add (new Word ("july", "agẹmo", 0));
        words.add (new Word ("august", "ogun", 0));
        words.add (new Word ("september", "owéré", 0));
        words.add (new Word ("october", "owara", 0));
        words.add (new Word ("november", "bèlu", 0));
        words.add (new Word ("december", "opé", 0));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter = new WordAdapter (this, words, R.color.category_daysmonths);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById (R.id.word_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter (wordadapter);


    }
}
