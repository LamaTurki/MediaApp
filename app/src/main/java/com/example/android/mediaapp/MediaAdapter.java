package com.example.android.mediaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lama on 8/4/2017 AD.
 */

public class MediaAdapter extends ArrayAdapter<media> {


    public MediaAdapter(Context context, ArrayList<media> medialist) {
        super(context, 0, medialist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        media current = getItem(position);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.name);

        miwokTextView.setText(current.getmName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (current.hasImage()) {
            imageView.setImageResource(current.getmImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }



        return listItemView;
    }
}
