package com.example.android.slidingtabs;

/**
 * Created by Salvador on 15/08/2016.
 */
public class Food extends TourItem {

    String mRecipe;

    public  Food (int title, int icon, String recipe) {

        super(title, icon);
        mRecipe = recipe;

    }

    public Food ( int title,  int description, int icon, int picture) {
        super(title, description, icon, picture);

    }


}
