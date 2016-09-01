package com.example.android.slidingtabs;

/**
 * Created by Salvador on 15/08/2016.
 */
public class BikeRoute extends TourItem {

    String mDates;

    public BikeRoute(int title, int description, int icon, int picture, String dates ) {
        super(title, description, icon, picture);
        mDates = dates;

    }

    public BikeRoute(int title, int description, int icon, int picture) {
        super(title, description, icon, picture);


    }

    public BikeRoute(int title, int icon) {

        super(title,icon);
    }


}
