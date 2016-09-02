package com.example.android.slidingtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceActivityFragment extends Fragment {

    public  static  final   String  ARG_PAGE = "ARG_PAGE";

    private int mPage;

    // This constructor adds information about each fragment through
    // a bundle object using the ARG_PAGE dictionary index. This constructor
    // allows to pass the page number when a new fragment is instantiated.
    public static PlaceActivityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PlaceActivityFragment fragment = new PlaceActivityFragment();
        fragment.setArguments(args);
        return fragment;

    }

    // The onCreate method is overloaded to get the page number
    // and saved on the mPage property.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Inflates the main view that contains all the child elements
        View rootView = inflater.inflate(R.layout.fragment_tour, container, false);

        // Creates the Festivals Array and populates it
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.torres_serrano_title,R.string.torres_serrano_description,R.drawable.iconotorresdeserrano,R.drawable.fototorresdeserrano));
        places.add(new Place (R.string.micalet_title,R.string.micalet_description, R.drawable.iconomicalet,R.drawable.fotomicalet));
        places.add(new Place(R.string.ciudad_ciencias_title,R.string.ciudad_ciencias_description,R.drawable.iconociudadartesyciencias,R.drawable.fotociudadartesyciencias));
        places.add(new Place(R.string.catedral_title, R.string.cathedral_description,R.drawable.iconocatedraldevalencia,R.drawable.fotocatedral));

        final PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        final ListView listView = (ListView) rootView.findViewById(R.id.tour_category_list_view);

        listView.setAdapter(adapter);

        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Place festival = (Place) places.get(i);

                Toast.makeText(getContext(),festival.getmTitle(),Toast.LENGTH_LONG);

                Log.v("PlaceXX",getResources().getString(festival.getmTitle()));
                Log.v("PlaceXX",getResources().getString(festival.getmDescription()));
                Log.v("PlaceXX",getResources().getString(festival.getmPicture()));

                Intent intent = new Intent(getActivity(), PlaceDetail.class);

                intent.putExtra("Foto", festival.getmPicture());
                intent.putExtra("Title", festival.getmTitle());
                intent.putExtra("Description", festival.getmDescription());

                startActivity(intent);

            }

        });

        return rootView;
    }
}
