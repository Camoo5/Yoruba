package com.example.android.yoruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("good morning", "ek’aro", 0));
        words.add (new Word ("good afternoon", "ek'asan", 0));
        words.add (new Word ("good evening", "ek'ale", 0));
        words.add (new Word ("what is your name?", "ki lo oruko e", 0));
        words.add (new Word ("my name is", "oruko mi ni", 0));
        words.add (new Word ("welcome", "ek'abo", 0));
        words.add (new Word ("hello my friend", "bawoni Oremi", 0));
        words.add (new Word ("how are you?", "bawo lowa", 0));
        words.add (new Word ("i'm fine,thank you", "mowa dada, Ese", 0));
        words.add (new Word ("come in", "wole wa", 0));
        words.add (new Word ("good night", "od'aro", 0));
        words.add (new Word ("see you later", "mari e ni'gba mi", 0));
        words.add (new Word ("good bye", "od'abo", 0));
        words.add (new Word ("i will be right back", "mon padabo", 0));
        words.add (new Word ("happy birthday", "eku ojo ibi", 0));
        words.add (new Word ("happy new year", "eku odun tuntun", 0));
        words.add (new Word ("congratulations", "eku ori ire", 0));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter = new WordAdapter (this, words, R.color.category_phrases);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById (R.id.word_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter (wordadapter);


    }
}