package com.example.android.slidingtabs;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salvador on 15/08/2016.
 */
public class FestivalAdapter extends ArrayAdapter<Festival> {

    public FestivalAdapter(Fragment context, ArrayList<Festival> Festivals) {
        super (context,0, Festivals);
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

        TextView titleTextView = new TextView(getContext());
        titleTextView.setText(currentFestival.getmTitle());
        listView.add

        return super.getView(position, convertView, parent);
    }
}
