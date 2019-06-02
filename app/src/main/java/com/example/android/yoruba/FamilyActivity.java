package com.example.android.yoruba;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        final ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("father", "baba", R.drawable.family_father,R.raw.father));
        words.add (new Word ("mother", "mama", R.drawable.family_mother,R.raw.mother ));
        words.add (new Word ("son", "omo okunrin", R.drawable.family_son,R.raw.son ));
        words.add (new Word ("daughter", "omo obinrin", R.drawable.family_daughter,R.raw.daughter ));
        words.add (new Word ("older brother", "egbon okunrin", R.drawable.family_older_brother,R.raw.older_brother));
        words.add (new Word ("younger brother", "aburo okunrin", R.drawable.family_younger_brother,R.raw.younger_brother ));
        words.add (new Word ("older sister", "egbon obinrin", R.drawable.family_older_sister,R.raw.older_sister  ));
        words.add (new Word ("younger sister", "aburo obinrin", R.drawable.family_younger_sister,R.raw.younger_sister ));
        words.add (new Word ("grandmother", "mama mama", R.drawable.family_grandmother,R.raw.grand_mother));
        words.add (new Word ("grandfather", "baba baba", R.drawable.family_grandfather,R.raw.grand_father));
        words.add (new Word ("baby", "omo ikoko", R.drawable.baby,R.raw.baby ));
        words.add (new Word ("relative", "ibatan", R.drawable.relative,R.raw.relative));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter = new WordAdapter (this, words, R.color.category_family);


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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
}
