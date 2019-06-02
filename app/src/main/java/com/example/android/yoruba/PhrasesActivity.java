package com.example.android.yoruba;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        final ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("good morning", "ek’aro", 0,R.raw.good_morning));
        words.add (new Word ("good afternoon", "ek'asan", 0,R.raw.good_afternoon ));
        words.add (new Word ("good evening", "ek'ale", 0,R.raw.good_evening ));
        words.add (new Word ("what is your name?", "ki lo oruko e", 0,R.raw.what_is_your_name ));
        words.add (new Word ("my name is", "oruko mi ni", 0,R.raw.my_name_is ));
        words.add (new Word ("welcome", "ek'abo", 0,R.raw.welcome ));
        words.add (new Word ("hello my friend", "bawoni Oremi", 0,R.raw.hello_my_friend ));
        words.add (new Word ("how are you?", "bawo lowa", 0,R.raw.how_are_you ));
        words.add (new Word ("i'm fine,thank you", "mowa dada, Ese", 0,R.raw.i_am_fine_thank_you));
        words.add (new Word ("come in", "wole wa", 0,R.raw.come_in ));
        words.add (new Word ("good night", "od'aro", 0,R.raw.good_night ));
        words.add (new Word ("see you later", "mari e ni'gba mi", 0,R.raw.see_you_later ));
        words.add (new Word ("good bye", "od'abo", 0,R.raw.good_bye));
        words.add (new Word ("i will be right back", "mon padabo", 0,R.raw.i_will_be_right_back));
        words.add (new Word ("happy birthday", "eku ojo ibi", 0,R.raw.happy_birthday));
        words.add (new Word ("happy new year", "eku odun tuntun", 0,R.raw.happy_new_year));
        words.add (new Word ("congratulations", "eku ori ire", 0,R.raw.congratulations));

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

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
}