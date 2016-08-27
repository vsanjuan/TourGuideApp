package com.example.android.slidingtabs;

import android.os.Parcel;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mDates);
    }

    protected Festival(Parcel in) {
        super(in);
        this.mDates = in.readString();
    }

    public static final Creator<Festival> CREATOR = new Creator<Festival>() {
        @Override
        public Festival createFromParcel(Parcel source) {
            return new Festival(source);
        }

        @Override
        public Festival[] newArray(int size) {
            return new Festival[size];
        }
    };
}
