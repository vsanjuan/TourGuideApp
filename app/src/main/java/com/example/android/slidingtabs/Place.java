package com.example.android.slidingtabs;

import android.location.Location;

/**
 * Created by Salvador on 15/08/2016.
 */
public class Place extends TourItem {

    Location mLocation;

    public Place(int title, int description, int icon, int picture, Location location ) {
        super(title, description, icon, picture);
        mLocation = location;

    }

    public Place(int title, int description, int icon, int picture) {
        super(title, description, icon, picture);


    }

    public Place(int title, int icon) {

        super(title,icon);
    }


}
