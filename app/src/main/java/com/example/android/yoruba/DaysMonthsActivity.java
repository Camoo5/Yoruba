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
            words.add (new Word ("monday", "Ọjọ́ Ajé", R.raw.monday));
            words.add (new Word ("tuesday", "Ọjọ́ Iségun",R.raw.tuesday));
            words.add (new Word ("wednesday", "Ọjọ́ ‘Rú",R.raw.wednesday));
            words.add (new Word ("thursday", "Ọjọ́ Bo",R.raw.thursday));
            words.add (new Word ("friday", " Ọjọ́ Ẹti",R.raw.friday));
            words.add (new Word ("saturday", "Ọjọ́ Abameta",R.raw.saturday));
            words.add (new Word ("sunday", "Ọjọ́ Aiku",R.raw.sunday));
            words.add (new Word ("january", "Seere",R.raw.january));
            words.add (new Word ("february", "Erele",R.raw.february));
            words.add (new Word ("march", "Erénà",R.raw.march));
            words.add (new Word ("april", "Igbe",R.raw.april));
            words.add (new Word ("may", "Èbìbí",R.raw.may));
            words.add (new Word ("june", "Okudu",R.raw.june));
            words.add (new Word ("july", "Agẹmo",R.raw.july));
            words.add (new Word ("august", "Ogun",R.raw.august));
            words.add (new Word ("september", "Òwéré",R.raw.september));
            words.add (new Word ("october", "Ọwara",R.raw.october));
            words.add (new Word ("november", "Bèlu",R.raw.november));
            words.add (new Word ("december", "Òpé",R.raw.december));

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
