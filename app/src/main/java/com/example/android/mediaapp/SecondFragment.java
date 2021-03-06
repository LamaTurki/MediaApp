package com.example.android.mediaapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static SecondFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_list, container, false);
        final ArrayList<media> m = new ArrayList<media>();
        m.add(new media("track1", R.raw.track1));
        m.add(new media("track2", R.raw.track2));
        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), PlayerActivity.class);
                media mymedia = m.get(position);
                intent.putExtra("title",mymedia.getmName() );
                intent.putExtra("track",mymedia.getmTrack() );
                intent.putExtra("has image", false);
                startActivity(intent);
            }});
        MediaAdapter adapter = new MediaAdapter(getActivity(), m);
        listView.setAdapter(adapter);
        return rootView;
    }
    }

