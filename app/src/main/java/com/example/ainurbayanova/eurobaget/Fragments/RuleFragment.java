package com.example.ainurbayanova.eurobaget.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ainurbayanova.eurobaget.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class RuleFragment extends Fragment {


    CarouselView carouselView;
    View view;

    public RuleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_rule, container, false);
        initCarousel();
        return view;
    }

    private void initCarousel() {
        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(5);
        carouselView.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View customView = getLayoutInflater().inflate(R.layout.design_of_carousel,null);
                TextView month = customView.findViewById(R.id.month);
                TextView price = customView.findViewById(R.id.price);
                LinearLayout linearLayout = customView.findViewById(R.id.backgroundColor);
                switch (position){
                    case 0:
                        month.setText("1 MONTH");
                        price.setText("890 tg");
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.bigColor));
                        break;
                    case 1:
                        month.setText("2 MONTH");
                        price.setText("1590 tg");
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 2:
                        month.setText("3 MONTH");
                        price.setText("2290 tg");
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.third));
                        break;
                    case 3:
                        month.setText("6 MONTH");
                        price.setText("3190 tg");
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.orange));
                        break;
                    case 4:
                        month.setText("1 YEAR");
                        price.setText("5000 tg");
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                }
                return customView;
            }
        });
    }

}
