package com.example.ainurbayanova.eurobaget.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ainurbayanova.eurobaget.R;
import com.example.ainurbayanova.eurobaget.interfaces.ItemClickListener;
import com.example.ainurbayanova.eurobaget.modules.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyTViewHolder> {
    private Context context;
    private List<Users> noteList;
    DateFormat dateF;
    String date;
    ItemClickListener itemClickListener;

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView name;
        TextView time;
        public MyTViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            time = view.findViewById(R.id.time);
            imageView = view.findViewById(R.id.imageView);

        }

    }

    public UserAdapter(Context context, List<Users> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_of_users, parent, false);
        manageDate();
        return new MyTViewHolder(itemView);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyTViewHolder holder, int position) {
        Users item = noteList.get(position);
        holder.name.setText(item.getName());
        holder.time.setText(item.getTime());
        Glide.with(context).load(item.getImage()).into(holder.imageView);
    }

    public void manageDate() {
        dateF = new SimpleDateFormat("dd.MM");//2001.07.04
        date = dateF.format(Calendar.getInstance().getTime());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

}