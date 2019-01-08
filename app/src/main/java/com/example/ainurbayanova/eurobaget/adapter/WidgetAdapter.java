package com.example.ainurbayanova.eurobaget.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ainurbayanova.eurobaget.R;
import com.example.ainurbayanova.eurobaget.interfaces.ItemClickListener;
import com.example.ainurbayanova.eurobaget.modules.Widget;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class WidgetAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Widget> widgets;
    ItemClickListener itemClickListener;

    public WidgetAdapter(Context context, List<Widget> widgets) {
        this.mContext = context;
        this.widgets = widgets;
    }
    @Override
    public int getCount() {
        return widgets.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.design_of_widgets, null);
            CircleImageView circleImageView = convertView.findViewById(R.id.circleImage);
            TextView textView = convertView.findViewById(R.id.name);
            TextView podrobno = convertView.findViewById(R.id.podrobno);

            Glide.with(mContext).load(widgets.get(position).getImage()).into(circleImageView);
            textView.setText(widgets.get(position).getNameOfImage());

            podrobno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v,position);
                }
            });
        }

        return convertView;
    }

    public void setOnWidgetClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

}