package com.example.ainurbayanova.eurobaget.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ainurbayanova.eurobaget.R;
import com.example.ainurbayanova.eurobaget.activities.AddUser;
import com.example.ainurbayanova.eurobaget.adapter.UserAdapter;
import com.example.ainurbayanova.eurobaget.modules.Users;

import java.util.ArrayList;
import java.util.List;

public class Users_fragment extends Fragment {

    public Users_fragment() {
        // Required empty public constructor
    }

    View view;
    RecyclerView recyclerView;
    UserAdapter adapter;
    List<Users> users;
    TextView pastPastDay;
    TextView pastDay;
    FloatingActionButton fab;
    TextView nowDay;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.users_fragment, container, false);
        initWidgets();
        initializeRecycler();
        setClickListenerForDays();
        initAnimationForRecyclerView();
        deleteWithSwipe();
        fabClickListener();
        return view;
    }
    public void initWidgets(){
        recyclerView = view.findViewById(R.id.recyclerView);
        users = new ArrayList<>();
        pastPastDay = view.findViewById(R.id.pastPastDay);
        pastDay = view.findViewById(R.id.pastDay);
        nowDay = view.findViewById(R.id.nowDay);
        editText = view.findViewById(R.id.editText);
        fab = view.findViewById(R.id.fab);

    }

    public void initializeRecycler(){
        users.add(new Users("Joha","12,312.12","https://www.trickscity.com/wp-content/uploads/2018/02/cute-girl-profile-pics.jpg"));
        users.add(new Users("Zhakhangir","15,312.12","http://www.bistiproofpage.com/wp-content/uploads/2018/04/cute-profile-pics-for-whatsapp-images.png"));
        adapter = new UserAdapter(getActivity(),users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
    public void setClickListenerForDays(){
        pastPastDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pastPastDay.setBackgroundResource(R.drawable.border_for_days);
                pastDay.setBackgroundResource(R.drawable.border);
                nowDay.setBackgroundResource(R.drawable.border);

                pastPastDay.setTextColor(getResources().getColor(R.color.white));
                pastDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                nowDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                initAnimationForRecyclerView();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutAnimation(null);
                    }
                },1000);
            }
        });
        pastDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pastDay.setBackgroundResource(R.drawable.border_for_days);
                pastPastDay.setBackgroundResource(R.drawable.border);
                nowDay.setBackgroundResource(R.drawable.border);

                pastPastDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                pastDay.setTextColor(getResources().getColor(R.color.white));
                nowDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutAnimation(null);
                    }
                },1000);
                initAnimationForRecyclerView();
            }
        });
        nowDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pastDay.setBackgroundResource(R.drawable.border);
                pastPastDay.setBackgroundResource(R.drawable.border);
                nowDay.setBackgroundResource(R.drawable.border_for_days);

                pastPastDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                pastDay.setTextColor(getResources().getColor(R.color.colorPrimary));
                nowDay.setTextColor(getResources().getColor(R.color.white));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutAnimation(null);
                    }
                },1000);
                initAnimationForRecyclerView();
            }
        });
    }
    public void initAnimationForRecyclerView(){
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
        recyclerView.setLayoutAnimation(animation);
    }
    public void deleteWithSwipe(){
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                users.remove(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
    public void fabClickListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddUser.class),1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
