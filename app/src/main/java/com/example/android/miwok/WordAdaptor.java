package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.imageView;

/**
 * Created by usa19 on 7/10/2017.
 */

//inhereit from the ArrayAdapter class and expect the adapter accept an array of word object
public class WordAdaptor extends ArrayAdapter<Word> {

    private int mColorID;

    public WordAdaptor(Context context, ArrayList<Word> word, int colorID) {
        super(context, 0, word);
        mColorID = colorID;
    }

    //private static final String
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the word object at the current position
        Word currentWord = getItem(position);
        //find the textView labeled original
        TextView MiwokTextView = (TextView) listItemView.findViewById(R.id.original);
        //set that textView with the Miwok text from the word object
        MiwokTextView.setText(currentWord.getMiwokTranslate());

        TextView defTextView = (TextView) listItemView.findViewById(R.id.translate);
        defTextView.setText(currentWord.getDefaultTranslate());

        ImageView iconView = (ImageView) listItemView.findViewById(imageView);
        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageID());
            //need to explicitly set the view to visible because views get reused
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        //set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorID);
        //set the color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
