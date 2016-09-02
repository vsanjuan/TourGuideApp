package com.example.android.slidingtabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetail extends AppCompatActivity {

    private static final String FOOD = "Food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_item_detail);

        Bundle extras = getIntent().getExtras();

        Log.v("FoodDetail", getResources().getString(extras.getInt("Title")));
        Log.v("FoodDetail",Integer.toString(extras.getInt("Foto")) );

        // TourItem mSelectedFood = (TourItem) this.getIntent().getSerializableExtra(FOOD);

        ImageView imageView = (ImageView) findViewById(R.id.tour_item_detail_picture);
        TextView textViewTitle = (TextView) findViewById(R.id.tour_item_detail_title);
        TextView textViewDescription = (TextView) findViewById(R.id.tour_item_detail_description);

        imageView.setImageResource(extras.getInt("Foto",R.mipmap.fotofallas));
        textViewTitle.setText(getResources().getString(extras.getInt("Title")));
        textViewDescription.setText(getResources().getString(extras.getInt("Description")));


    }
}
