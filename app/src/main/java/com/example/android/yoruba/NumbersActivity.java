package com.example.android.yoruba;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);


        //Create an Arraylist of words objects
        final ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("one", "okan", R.drawable.number_one,R.raw.number_one));
        words.add (new Word ("two", "meji", R.drawable.number_two,R.raw.number_two ));
        words.add (new Word ("three", "mẹta", R.drawable.number_three,R.raw.number_three ));
        words.add (new Word ("four", "mẹrin", R.drawable.number_four,R.raw.number_four ));
        words.add (new Word ("five", "marun", R.drawable.number_five,R.raw.number_five ));
        words.add (new Word ("six", "mefa", R.drawable.number_six,R.raw.number_six ));
        words.add (new Word ("seven", "meje", R.drawable.number_seven,R.raw.number_seven ));
        words.add (new Word ("eight", "mẹsan", R.drawable.number_eight,R.raw.number_eight ));
        words.add (new Word ("nine", "mẹsan", R.drawable.number_nine,R.raw.number_nine ));
        words.add (new Word ("ten", "mẹwàá", R.drawable.number_ten,R.raw.number_ten ));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter = new WordAdapter (this, words, R.color.category_numbers);


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
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
}

