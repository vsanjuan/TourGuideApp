package com.example.android.slidingtabs;

/**
 * Created by Salvador on 15/08/2016.
 */
public class Festival extends TourItem {

    String mDates;

    public Festival ( int title,  int description, int icon, int picture, String dates ) {
        super(title, description, icon, picture);
        mDates = dates;

    }

    public Festival ( int title,  int description, int icon, int picture) {
        super(title, description, icon, picture);


    }

    public Festival ( int title, int icon) {

        super(title,icon);
    }


}
