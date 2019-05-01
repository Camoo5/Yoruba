package com.example.android.yoruba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName ();


    /**
     * This is our own custom constructor (It doesn't mirror a superclass constructor)
     * The context is used to inflate the layout file, and the
     * list is the data we want to populate into the lists.
     *
     * @param context The current context . Use to inflate the layout file.
     * @param words   A List of Word objects to display in a list
     */

    public WordAdapter(Activity context, ArrayList <Word> words) {
        // Here, we intialise the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a singe TextView
        // Because this a custome adapter for two TextViews and an ImageView, the adapter is not
        // going to use the second argument, so it can be any value. Here, we used 0.
        super (context, 0, words);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate(
                    R.layout.list_item, parent,false);
        }
        //Get the {@link Word} object located at this position in the list
        Word currentWord = getItem (position);

        //Find the TextView in the list_item.xml with the ID defaultTranslation
        TextView nameTextView = (TextView) listItemView.findViewById (R.id.default_textView);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        nameTextView.setText (currentWord.getDefaultTranslation ());

        //Find the TextView in the list_item.xml with the ID yorubaTranslation
        nameTextView = (TextView) listItemView.findViewById (R.id.yoruba_textView);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        nameTextView.setText (currentWord.getYorubaTranslation ());

        //Return the whole list item layout (containing 2 TextViews
        return listItemView;
    }
}