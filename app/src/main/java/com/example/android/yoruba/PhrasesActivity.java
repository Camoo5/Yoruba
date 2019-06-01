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
        words.add (new Word("Good morning?","Ek’aro",R.raw.good_morning));
        words.add (new Word("Good afternoon?","Ek'asan",R.raw.good_afternoon));
        words.add (new Word("Good evening?","Ek'ale",R.raw.good_evening));
        words.add (new Word("What is your name?","Ki lo oruko e",R.raw.what_is_your_name));
        words.add (new Word("My name is?","Oruko mi ni",R.raw.my_name_is));
        words.add (new Word("Welcome?","Ek'abo",R.raw.welcome));
        words.add (new Word("Hello my friend","Bawoni Oremi",R.raw.hello_my_friend));
        words.add (new Word("How are you?","Bawo lowa",R.raw.how_are_you));
        words.add (new Word("I'm fine,thank you", "Mowa dada, Ese",R.raw.i_am_fine_thank_you));
        words.add (new Word("Come in","Wole wa",R.raw.come_in));
        words.add (new Word("Good night","Od'aro",R.raw.good_night));
        words.add (new Word("See you later","Mari e ni'gba mi",R.raw.see_you_later));
        words.add (new Word("Good bye","Od'abo",R.raw.good_bye));
        words.add (new Word("I will be right back","Mon padabo",R.raw.i_will_be_right_back));
        words.add (new Word("Happy birthday","Eku ojo ibi",R.raw.happy_birthday));
        words.add (new Word("Happy new year","Eku odun tuntun",R.raw.happy_new_year));
        words.add (new Word("Congratulations","Eku ori ire",R.raw.congratulations));

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
