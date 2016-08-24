package com.example.android.slidingtabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class FestivalDetail extends AppCompatActivity {

    private static final String FESTIVAL = "Festival";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_detail);

        Festival mSelectedFestival = (Festival) this.getIntent().getSerializableExtra(FESTIVAL);

        ImageView imageView = (ImageView) findViewById(R.id.festival_detail_picture);
        imageView.setImageResource(mSelectedFestival.getmPicture());

        TextView textViewTitle = (TextView) findViewById(R.id.festival_detail_title);
        textViewTitle.setText(mSelectedFestival.getmTitle());

        TextView textViewDescription = (TextView) findViewById(R.id.festival_detail_description);
        textViewDescription.setText(mSelectedFestival.getmDescription());

    }
}
