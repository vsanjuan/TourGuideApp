package com.example.android.slidingtabs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Salvador on 15/08/2016.
 */
public class TourItem implements Parcelable {

    private int mTitle;  // Use int because the text will be a string resource in strings.xml
    private int mDescription; // Use int because the text will be a string resource in strings.xml
    private int mIcon;
    private int mPicture;
    private LatLng mLocation;  // Additional information

    public TourItem (int title,  int icon) {

        mTitle = title;
        mIcon = icon;
    }

    public TourItem(int title, int description, int icon, int picture) {

        mTitle = title;
        mIcon = icon;
        mDescription = description;
        mPicture = picture;
    }

    public TourItem (int title, int description, int icon, int picture, LatLng location) {

        mTitle = title;
        mIcon = icon;
        mDescription = description;
        mPicture = picture;
        mLocation = location;
    }

    public int getmTitle() {
        return mTitle;
    }

    public int getmIcon() {
        return mIcon;
    }

    public int getmDescription() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mTitle);
        dest.writeInt(this.mDescription);
        dest.writeInt(this.mIcon);
        dest.writeInt(this.mPicture);
        dest.writeParcelable(this.mLocation, flags);
    }

    protected TourItem(Parcel in) {
        this.mTitle = in.readInt();
        this.mDescription = in.readInt();
        this.mIcon = in.readInt();
        this.mPicture = in.readInt();
        this.mLocation = in.readParcelable(LatLng.class.getClassLoader());
    }

    public static final Parcelable.Creator<TourItem> CREATOR = new Parcelable.Creator<TourItem>() {
        @Override
        public TourItem createFromParcel(Parcel source) {
            return new TourItem(source);
        }

        @Override
        public TourItem[] newArray(int size) {
            return new TourItem[size];
        }
    };
}
