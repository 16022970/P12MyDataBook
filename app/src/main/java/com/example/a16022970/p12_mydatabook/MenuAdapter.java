package com.example.a16022970.p12_mydatabook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItems> {
    private ArrayList<MenuItems> items;
    private Context context;
    private TextView tvName;
    private ImageView imageView;


    public MenuAdapter(Context context, int resource, ArrayList<MenuItems> items){
        super(context, resource, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvName = (TextView) rowView.findViewById(R.id.tvname);
        imageView = (ImageView) rowView.findViewById(R.id.iv);
        MenuItems currentItem = items.get(position);

        tvName.setText(currentItem.getName());
        imageView.setImageResource(currentItem.getIcon());

        return rowView;
    }



}
