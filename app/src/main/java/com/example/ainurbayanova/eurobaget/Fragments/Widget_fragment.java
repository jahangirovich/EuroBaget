package com.example.ainurbayanova.eurobaget.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ainurbayanova.eurobaget.R;
import com.example.ainurbayanova.eurobaget.activities.AddImage;
import com.example.ainurbayanova.eurobaget.activities.DetailOfWidget;
import com.example.ainurbayanova.eurobaget.adapter.WidgetAdapter;
import com.example.ainurbayanova.eurobaget.interfaces.ItemClickListener;
import com.example.ainurbayanova.eurobaget.modules.Widget;
import java.util.ArrayList;
import java.util.List;

public class Widget_fragment extends Fragment {
    View view;
    GridView gridView;
    WidgetAdapter adapter;
    List<Widget> widgets = new ArrayList<>();
    FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.widget_fragment, container, false);
        initWidgets();
        initializeAdapter();
        setFabClickListener();
        return view;
    }
    public void initWidgets(){
        gridView = view.findViewById(R.id.gridView);
        fab = view.findViewById(R.id.fab);
    }
    public void initializeAdapter(){
        widgets.add(new Widget("Kartinka","https://2.bp.blogspot.com/-_lL6A07WTwU/WtgKCZS-g3I/AAAAAAAAF9s/95wTj08fzmAx7FuTLE89E9kfi6n87fRFQCEwYBhgL/s1600/cool%2Bprofile%2Bpicture.png","asdasda"));
        widgets.add(new Widget("Pachetino","https://uvmbored.com/wp-content/uploads/2017/02/54-atxl.jpg","asdasda"));
        widgets.add(new Widget("Moncart","https://pbs.twimg.com/profile_images/747871538221834240/hKVSMFXo.jpg","asdasda"));
        adapter = new WidgetAdapter(getActivity(),widgets);
        gridView.setAdapter(adapter);
        adapter.setOnWidgetClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                startActivity(new Intent(getActivity(), DetailOfWidget.class));
            }
        });
    }
    public void setFabClickListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddImage.class),1);
            }
        });
    }
}
