package com.example.android.yoruba;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;
    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener () {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause ();
                mMediaPlayer.seekTo (0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start ();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer ();
            }
        }
    };
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener () {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer ();
        }
    };


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate (R.layout.word_list, container, false);

        //create and setup link to get audio focus
        mAudioManager = (AudioManager) getActivity ().getSystemService (Context.AUDIO_SERVICE);


        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity ().getSystemService (Context.AUDIO_SERVICE);

        //Create an Arraylist of words objects
        final ArrayList <Word> words = new ArrayList <Word> ();
        words.add (new Word ("good morning", "ek’aro", 0, R.raw.good_morning));
        words.add (new Word ("good afternoon", "ek'asan", 0, R.raw.good_afternoon));
        words.add (new Word ("good evening", "ek'ale", 0, R.raw.good_evening));
        words.add (new Word ("what is your name?", "ki lo oruko e", 0, R.raw.what_is_your_name));
        words.add (new Word ("my name is", "oruko mi ni", 0, R.raw.my_name_is));
        words.add (new Word ("welcome", "ek'abo", 0, R.raw.welcome));
        words.add (new Word ("hello my friend", "bawoni Oremi", 0, R.raw.hello_my_friend));
        words.add (new Word ("how are you?", "bawo lowa", 0, R.raw.how_are_you));
        words.add (new Word ("i'm fine,thank you", "mowa dada, Ese", 0, R.raw.i_am_fine_thank_you));
        words.add (new Word ("come in", "wole wa", 0, R.raw.come_in));
        words.add (new Word ("good night", "od'aro", 0, R.raw.good_night));
        words.add (new Word ("see you later", "mari e ni'gba mi", 0, R.raw.see_you_later));
        words.add (new Word ("good bye", "od'abo", 0, R.raw.good_bye));
        words.add (new Word ("i will be right back", "mon padabo", 0, R.raw.i_will_be_right_back));
        words.add (new Word ("happy birthday", "eku ojo ibi", 0, R.raw.happy_birthday));
        words.add (new Word ("happy new year", "eku odun tuntun", 0, R.raw.happy_new_year));
        words.add (new Word ("congratulations", "eku ori ire", 0, R.raw.congratulations));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter = new WordAdapter (getActivity (), words, R.color.category_phrases);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        final ListView listView = rootView.findViewById (R.id.word_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter (wordadapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer ();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get (position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus (mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.


                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create (getActivity (), word.getAudioResourceId ());

                    // Start the audio file
                    mMediaPlayer.start ();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener (mCompletionListener);

                }
            }
        });
        return rootView;
    }

    // release audio resource when activity is stoppe
    @Override
    public void onStop() {
        super.onStop ();
        releaseMediaPlayer ();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release ();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //Regardless of whether or not we were granted audio focus, abandon it. This also
            //Unregisters the AudioFocusChangeListener so we don't get anymore callbacks
            mAudioManager.abandonAudioFocus (mOnAudioFocusChangeListener);


        }
    }

}




