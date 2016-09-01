package com.example.android.slidingtabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Salvador on 13/08/2016.
 */
public class TourFragmentPagerAdapter extends FragmentPagerAdapter {
    final int  PAGE_COUNT = 4;
    private String tabTitles[] = new String[] {"Food", "Festivals", "Places","Biking routes"};
    private Context context;

    public TourFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public  int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0 ) {
            return FoodActivityFragment.newInstance(position+1);
        }

        if (position == 1 ) {
            return FestivalActivityFragment.newInstance(position+1);
        }

        if (position == 2 ) {
            return PlaceActivityFragment.newInstance(position+1);
        }

        if (position == 3 ) {
            return BikeRouteActivityFragment.newInstance(position+1);
        }

        return  BikeRouteActivityFragment.newInstance(position+1);
    }

    @Override
    public CharSequence getPageTitle(int position){
        // Generate title base on item position
        return tabTitles[position];
    }
}
