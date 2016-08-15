package com.example.android.slidingtabs;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Salvador on 15/08/2016.
 */
public class TourItem   {

    private String mTitle;
    private String mDescription;
    private int mIcon;
    private int mPicture;
    private LatLng mLocation;  // Additional information

    public TourItem (String title,  int icon) {

        mTitle = title;
        mIcon = icon;
    }

    public TourItem(String title, String description, int icon, int picture) {

        mTitle = title;
        mIcon = icon;
        mDescription = description;
        mPicture = picture;
    }

    public TourItem (String title, String description, int icon, int picture, LatLng location) {

        mTitle = title;
        mIcon = icon;
        mDescription = description;
        mPicture = picture;
        mLocation = location;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmIcon() {
        return mIcon;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmPicture() {
        if (mPicture != 0) {
            return mPicture;
        } else {
            return 0;
        }
    }

    public LatLng getmLocation() {
        if (mLocation != null) {
            return mLocation;
        } else {
            return null;
        }
    }
}
