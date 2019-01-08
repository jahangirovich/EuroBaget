package com.example.ainurbayanova.eurobaget.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ainurbayanova.eurobaget.R;
import com.example.ainurbayanova.eurobaget.adapter.ModeratorsAdapter;
import com.example.ainurbayanova.eurobaget.modules.moderator;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModeratorFragment extends Fragment {
    View view;
    GridView gridView;
    ArrayList<moderator> moderators = new ArrayList<>();
    ModeratorsAdapter adapter;
    public ModeratorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_moderator, container, false);
        gridView = view.findViewById(R.id.gridView);
        initGrid();
        return view;
    }

    public void initGrid(){
        initializeWidgets();
        adapter = new ModeratorsAdapter(getActivity(),moderators);
        gridView.setAdapter(adapter);
    }

    public void initializeWidgets(){
        moderators.add(new moderator("https://firebasestorage.googleapis.com/v0/b/reading-club-e69cc.appspot.com/o/user_images%2Fe60a71cf-7e15-4433-8467-5f277e73ef8d.jpeg?alt=media&token=ff2ee084-481d-42e3-a991-4910bfa608ab","Zhiger agai","CEO of reading club",R.color.second));
        moderators.add(new moderator("https://firebasestorage.googleapis.com/v0/b/reading-club-e69cc.appspot.com/o/user_images%2F0bf4a175-480f-4fb1-aeba-cd89acb6d1d3.jpeg?alt=media&token=ecb2af42-9949-40c9-a3f1-5e03eca8038b","Bakhytzhan","IT support",R.color.first));
        moderators.add(new moderator("https://firebasestorage.googleapis.com/v0/b/reading-club-e69cc.appspot.com/o/user_images%2Ff1fff740-10b2-4dca-b1bd-5ecae2106dea.jpeg?alt=media&token=74aa2abc-9aa4-40fa-b0e5-2b0d71326003","Baurzhan agai","ModeratorFragment of reading club",R.color.first));
        moderators.add(new moderator("https://firebasestorage.googleapis.com/v0/b/reading-club-e69cc.appspot.com/o/user_images%2F1543054311214.jpg?alt=media&token=952e2dab-8bd6-4a93-a1f9-6cf6dcdf7194","Zhiger","ModeratorFragment of reading club",R.color.first));
    }
}
