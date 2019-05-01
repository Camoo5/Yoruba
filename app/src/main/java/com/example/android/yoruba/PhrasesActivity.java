package com.example.android.yoruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_phrases);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        ArrayList<Word> words = new ArrayList <Word>();
        words.add (new Word("Good morning?","Ek’aro"));
        words.add (new Word("Good afternoon?","Ek'asan"));
        words.add (new Word("Good evening?","Ek'ale"));
        words.add (new Word("What is your name?","Ki lo oruko e"));
        words.add (new Word("My name is?","Oruko mi ni"));
        words.add (new Word("Welcome?","Ek'abo"));
        words.add (new Word("Hello my friend","Bawoni Oremi"));
        words.add (new Word("How are you?","Bawo lowa"));
        words.add (new Word("I'm fine,thank you", "Mowa dada, Ese"));
        words.add (new Word("And you?","Iwo na nko"));
        words.add (new Word("Good","Oda"));
        words.add (new Word("Thank you","Ese"));
        words.add (new Word("Come in","Wole wa"));
        words.add (new Word("Good night","Od'aro"));
        words.add (new Word("See you later","Mari e ni'gba mi"));
        words.add (new Word("Good bye","Od'abo"));
        words.add (new Word("I will be right back","Mon padabo"));
        words.add (new Word("Happy birthday","Eku ojo ibi"));
        words.add (new Word("Happy new year","Eku odun tuntun"));
        words.add (new Word("Congratulations","Eku ori ire"));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter =  new WordAdapter (this, words);

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        wordadapter = new WordAdapter (this, words);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById (R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(wordadapter);




    }
}
