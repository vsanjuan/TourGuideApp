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
public class FestivalActivityFragment extends Fragment {

    public  static  final   String  ARG_PAGE = "ARG_PAGE";

    private int mPage;

    // This constructor adds information about each fragment through
    // a bundle object using the ARG_PAGE dictionary index. This constructor
    // allows to pass the page number when a new fragment is instantiated.
    public static FestivalActivityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FestivalActivityFragment fragment = new FestivalActivityFragment();
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

        // return inflater.inflate(R.layout.fragment_festival, container, false);

        //Inflates the main view that contains all the child elements
        View rootView = inflater.inflate(R.layout.fragment_festival, container, false);

        // Creates the Festivals Array and populates it
        final ArrayList<Festival> festivals = new ArrayList<>();

        festivals.add(new Festival(R.string.fallas,R.string.fallas_description,R.mipmap.iconofallas,R.mipmap.fallafoto));
        festivals.add(new Festival (R.string.muixeranga_title,R.string.muixeranga_description, R.mipmap.muixerangaicon,R.mipmap.muixeranga));
        festivals.add(new Festival(R.string.feria_julio_title,R.string.feria_julio_description,R.mipmap.feriadejulioicon,R.mipmap.feriadejulio));
        festivals.add(new Festival(R.string.semana_santa_title, R.string.semana_santa_description,R.mipmap.semanasanta,R.mipmap.semanasanta));

        final FestivalAdapter adapter = new FestivalAdapter(getActivity(),festivals);

        final ListView listView = (ListView) rootView.findViewById(R.id.festival_list_view);

        listView.setAdapter(adapter);

        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //TourItem festival = (Festival) adapterView.getAdapter().getItem(i);
                Festival festival = (Festival) festivals.get(i);

                Toast.makeText(getContext(),festival.getmTitle(),Toast.LENGTH_LONG);

                Log.v("FestivalXX",getResources().getString(festival.getmTitle()));
                Log.v("FestivalXX",getResources().getString(festival.getmDescription()));
                Log.v("FestivalXX",getResources().getString(festival.getmPicture()));

                Intent intent = new Intent(getActivity(), FestivalDetail.class);

                intent.putExtra("Foto", festival.getmPicture());
                intent.putExtra("Title", festival.getmTitle());
                intent.putExtra("Description", festival.getmDescription());

                //intent.putExtra("Festival",festival);
                startActivity(intent);


            }

        });

        return rootView;
    }
}
