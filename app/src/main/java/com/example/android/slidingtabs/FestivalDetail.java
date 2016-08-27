package com.example.android.slidingtabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class FestivalDetail extends AppCompatActivity {

    private static final String FESTIVAL = "Festival";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_detail);

        Bundle extras = getIntent().getExtras();

        Log.v("FestivalDetail", getResources().getString(extras.getInt("Title")));
        Log.v("FestivalDetail",Integer.toString(extras.getInt("Foto")) );

        // TourItem mSelectedFestival = (TourItem) this.getIntent().getSerializableExtra(FESTIVAL);

        ImageView imageView = (ImageView) findViewById(R.id.festival_detail_picture);
        TextView textViewTitle = (TextView) findViewById(R.id.festival_detail_title);
        TextView textViewDescription = (TextView) findViewById(R.id.festival_detail_description);

        imageView.setImageResource(extras.getInt("Foto",R.mipmap.fallafoto));
        textViewTitle.setText(getResources().getString(extras.getInt("Title")));
        textViewDescription.setText(getResources().getString(extras.getInt("Description")));
        //textViewDescription.setText("Hola");



  /*      if (mSelectedFestival == null) {

            imageView.setImageResource(extras.getInt("Image",R.mipmap.fallafoto));
            textViewTitle.setText(extras.getString("Title"));
            textViewDescription.setText(extras.getString("Description"));

        } else {

            imageView.setImageResource(mSelectedFestival.getmPicture());
            textViewTitle.setText(mSelectedFestival.getmTitle());
            textViewDescription.setText(mSelectedFestival.getmDescription());

        }*/

    }
}
