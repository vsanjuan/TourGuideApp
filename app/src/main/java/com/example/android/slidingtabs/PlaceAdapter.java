package com.example.android.slidingtabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salvador on 15/08/2016.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super (context ,0 , places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tour_list_items, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Place currentPlace = getItem(position);

        TextView titleTextView = (TextView) listView.findViewById(R.id.title_tour_item);
        titleTextView.setText(currentPlace.getmTitle());

        ImageView iconImageView = (ImageView) listView.findViewById(R.id.icon_tour_item);
        iconImageView.setImageResource(currentPlace.getmIcon());



        return listView;
    }
}
