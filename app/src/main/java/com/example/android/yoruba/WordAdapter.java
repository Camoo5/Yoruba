package com.example.android.yoruba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter <Word> {

    //Resource id for background color of list
    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList <Word> words, int colorResourceId) {
        // Here, we intialise the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a singe TextView
        // Because this a custome adapter for two TextViews and an ImageView, the adapter is not
        // going to use the second argument, so it can be any value. Here, we used 0.
        super (context, 0, words);
        mColorResourceId = colorResourceId;
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
            listItemView = LayoutInflater.from (getContext ()).inflate (
                    R.layout.list_item, parent, false);
        }
        //Get the {@link Word} object located at this position in the list
        Word word_item = getItem (position);


        //Find the TextView in the list_item.xml with the ID default_text-View
        TextView defaultTextView = (TextView) listItemView.findViewById (R.id.default_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        defaultTextView.setText (word_item.getDefaultTranslation ());

        //Find the TextView in the list_item.xml with the ID yoruba text_view
        TextView yorubaTextView = (TextView) listItemView.findViewById (R.id.yoruba_text_view);
        // Get the Yoruba translation from the currentword object and set this text on
        // the Yoruba TextView
        yorubaTextView.setText (word_item.getYorubaTranslation ());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView mImageView = (ImageView) listItemView.findViewById (R.id.image);
        if (word_item.hasImage ()) {
            //if an image is available, display the provided image based on the resource ID
            mImageView.setImageResource (word_item.getImageResourceId ());
            //make the image view visible
            mImageView.setVisibility (View.VISIBLE);
        } else {
            mImageView.setVisibility (View.GONE);
        }

        //seach for the view with the give id
        View textContainer = listItemView.findViewById (R.id.text_container);

        // set its backgroung resource to the mColorResourceId
        textContainer.setBackgroundResource (mColorResourceId);


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}