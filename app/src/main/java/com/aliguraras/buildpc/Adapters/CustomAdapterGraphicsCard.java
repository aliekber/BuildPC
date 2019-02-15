package com.aliguraras.buildpc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aliguraras.buildpc.R;
import com.aliguraras.buildpc.models.GraphicsCard;

import java.util.ArrayList;

public class CustomAdapterGraphicsCard extends BaseAdapter {

    private ArrayList<GraphicsCard> items;
    private LayoutInflater inflater;

    public CustomAdapterGraphicsCard(Context context, ArrayList<GraphicsCard> items){
        this.items = items;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.spinner_item_custom, null);

        TextView spinnerItem = convertView.findViewById(R.id.spinnerTextView);

        spinnerItem.setText(items.get(position).getBrand() + " " + items.get(position).getModel() + " " + items.get(position).getSizeInGb());

        return convertView;
    }
}
