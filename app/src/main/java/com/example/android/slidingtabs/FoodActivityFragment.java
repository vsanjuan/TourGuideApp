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
public class FoodActivityFragment extends Fragment {

    public  static  final   String  ARG_PAGE = "ARG_PAGE";

    private int mPage;

    // This constructor adds information about each fragment through
    // a bundle object using the ARG_PAGE dictionary index. This constructor
    // allows to pass the page number when a new fragment is instantiated.
    public static FoodActivityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FoodActivityFragment fragment = new FoodActivityFragment();
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
        final ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food(R.string.allipebre_title,R.string.allipebre_description,R.drawable.iconoallipebre,R.drawable.fotoallipebre));
        foods.add(new Food (R.string.paella_title,R.string.paella_description, R.drawable.iconopaella,R.drawable.fotopaella));
        foods.add(new Food(R.string.orange_juice_title,R.string.orange_juice_description,R.drawable.iconozumo,R.drawable.fotozumonaranja));
        foods.add(new Food(R.string.orxata_title, R.string.orxata_description,R.drawable.iconoorxata,R.drawable.fotohorchata));

        final FoodAdapter adapter = new FoodAdapter(getActivity(),foods);

        final ListView listView = (ListView) rootView.findViewById(R.id.tour_category_list_view);

        listView.setAdapter(adapter);

        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Food festival = (Food) foods.get(i);

                Intent intent = new Intent(getActivity(), FoodDetail.class);

                intent.putExtra(getString(R.string.foto), festival.getmPicture());
                intent.putExtra(getString(R.string.title), festival.getmTitle());
                intent.putExtra(getString(R.string.description), festival.getmDescription());

                startActivity(intent);


            }

        });

        return rootView;
    }
}
