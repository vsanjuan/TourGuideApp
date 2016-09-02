package com.example.android.slidingtabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetail extends AppCompatActivity {

    private static final String PLACE = "Place";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_item_detail);

        Bundle extras = getIntent().getExtras();

        Log.v("PlaceDetail", getResources().getString(extras.getInt("Title")));
        Log.v("PlaceDetail",Integer.toString(extras.getInt("Foto")) );

        ImageView imageView = (ImageView) findViewById(R.id.tour_item_detail_picture);
        TextView textViewTitle = (TextView) findViewById(R.id.tour_item_detail_title);
        TextView textViewDescription = (TextView) findViewById(R.id.tour_item_detail_description);

        imageView.setImageResource(extras.getInt("Foto",R.mipmap.fotofallas));
        textViewTitle.setText(getResources().getString(extras.getInt("Title")));
        textViewDescription.setText(getResources().getString(extras.getInt("Description")));


    }
}
