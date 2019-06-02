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
        words.add (new Word("white","funfun",R.drawable.color_white));
        words.add (new Word("black","dúdú",R.drawable.color_black));
        words.add (new Word("brown","àwö ara",R.drawable.color_brown));
        words.add (new Word("yellow"," ìyèyè",R.drawable.color_mustard_yellow));
        words.add (new Word("grey","àwö eléérú",R.drawable.color_gray));
        words.add (new Word("red","pupa",R.drawable.color_red));
        words.add (new Word("green","ewéko",R.drawable.color_green));

        // Create an {@link WordAdapter}, whose data source is a list of
        // {@link Word}s. The adapter knows how to create list item views for each item
        // in the list.
        WordAdapter wordadapter =  new WordAdapter (this, words, R.color.category_colors);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView)findViewById (R.id.word_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(wordadapter);





    }
}
