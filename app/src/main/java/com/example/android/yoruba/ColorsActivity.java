package com.example.android.yoruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_colors);
        setContentView (R.layout.word_list);

        //Create an Arraylist of words objects
        ArrayList<Word> words = new ArrayList <Word>();
        words.add (new Word("white","funfun"));
        words.add (new Word("black","dúdú"));
        words.add (new Word("blue","àwö sánmà"));
        words.add (new Word("brown","àwö ara"));
        words.add (new Word("yellow"," ìyèyè"));
        words.add (new Word("gold","wúrà"));
        words.add (new Word("silver","fàdákà"));
        words.add (new Word("grey","àwö eléérú"));
        words.add (new Word("pink","pupa fêêrê"));
        words.add (new Word("red","pupa"));
        words.add (new Word("purple","àwö elésè àlùkò"));
        words.add (new Word("green","àwö ewéko"));
        words.add (new Word("indigo","aro"));



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
