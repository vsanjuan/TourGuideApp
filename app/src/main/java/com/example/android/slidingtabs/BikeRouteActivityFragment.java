package com.example.android.slidingtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class BikeRouteActivityFragment extends Fragment {

    public  static  final   String  ARG_PAGE = "ARG_PAGE";

    private int mPage;

    // This constructor adds information about each fragment through
    // a bundle object using the ARG_PAGE dictionary index. This constructor
    // allows to pass the page number when a new fragment is instantiated.
    public static BikeRouteActivityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BikeRouteActivityFragment fragment = new BikeRouteActivityFragment();
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

        // return inflater.inflate(R.layout.fragment_tour, container, false);

        //Inflates the main view that contains all the child elements
        View rootView = inflater.inflate(R.layout.fragment_tour, container, false);

        // Creates the BikeRoutes Array and populates it
        final ArrayList<BikeRoute> bikeroutes = new ArrayList<>();

        bikeroutes.add(new BikeRoute(R.string.bike_barx_title,R.string.bike_barx_description,R.drawable.iconorutabarx,R.drawable.fotorutabarx));
        bikeroutes.add(new BikeRoute (R.string.bike_benirrama_title,R.string.bike_benirrama_description, R.drawable.iconorutacilistabenirrama,R.drawable.fotorutaciclistabenirrama));
        bikeroutes.add(new BikeRoute(R.string.bike_enguera_title,R.string.bike_enguera_description,R.drawable.iconorutaciclistaenguera,R.drawable.fotorutaciclistaenguera));
        bikeroutes.add(new BikeRoute(R.string.bike_turis_title, R.string.bike_turis_description,R.drawable.iconorutaciclistaturis,R.drawable.fotorutaturis));

        final BikeRouteAdapter adapter = new BikeRouteAdapter(getActivity(),bikeroutes);

        final ListView listView = (ListView) rootView.findViewById(R.id.tour_category_list_view);

        listView.setAdapter(adapter);

        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                BikeRoute bikeroute = (BikeRoute) bikeroutes.get(i);


                Intent intent = new Intent(getActivity(), BikeRouteDetail.class);

                intent.putExtra(getString(R.string.foto), bikeroute.getmPicture());
                intent.putExtra(getString(R.string.title), bikeroute.getmTitle());
                intent.putExtra(getString(R.string.description), bikeroute.getmDescription());

                startActivity(intent);


            }

        });

        return rootView;
    }
}
