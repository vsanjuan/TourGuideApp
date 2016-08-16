package com.example.android.slidingtabs;

import android.app.Activity;
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
public class FestivalAdapter extends ArrayAdapter<Festival> {

    public FestivalAdapter(Activity context, ArrayList<Festival> Festivals) {
        super (context ,0 , Festivals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_page, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Festival currentFestival = getItem(position);

        TextView titleTextView = listView.findViewById(R.id.title_tour_item);
        titleTextView.setText(currentFestival.getmTitle());

        ImageView iconImageView = listView.findViewById(R.id.icon_tour_item);


        return listView;
    }
}
