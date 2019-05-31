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
        setContentView (R.layout.activity_daysmonths);
        setContentView (R.layout.word_list);;


            //Create an Arraylist of words objects
            final ArrayList <Word> words = new ArrayList <Word> ();
            words.add (new Word ("monday", "Ọjọ́ Ajé"));
            words.add (new Word ("tuesday", "Ọjọ́ Iségun"));
            words.add (new Word ("wednesday", "Ọjọ́ ‘Rú"));
            words.add (new Word ("thursday", "Ọjọ́ Bo"));
            words.add (new Word ("friday", " Ọjọ́ Ẹti"));
            words.add (new Word ("saturday", "Ọjọ́ Abameta"));
            words.add (new Word ("sunday", "Ọjọ́ Aiku"));
            words.add (new Word ("january", "Seere"));
            words.add (new Word ("february", "Erele"));
            words.add (new Word ("march", "Erénà"));
            words.add (new Word ("april", "Igbe"));
            words.add (new Word ("may", "Èbìbí"));
            words.add (new Word ("june", "Okudu"));
            words.add (new Word ("july", "Agẹmo"));
            words.add (new Word ("august", "Ogun"));
            words.add (new Word ("september", "Òwéré"));
            words.add (new Word ("october", "Ọwara"));
            words.add (new Word ("november", "Bèlu"));
            words.add (new Word ("december", "Òpé"));

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
