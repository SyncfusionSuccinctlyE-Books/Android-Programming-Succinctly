package com.example.userinterfacelayouts;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.userinterfacelayouts.DataItem;

public class CustomAdapter extends BaseAdapter {

	Context context;
    ArrayList<DataItem> data;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Context context, ArrayList<DataItem> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// See if the view needs to be inflated
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, null);
        }
        // Extract the desired views
        TextView nameText = (TextView) view.findViewById(R.id.nameValue);
        TextView phoneText = (TextView) view.findViewById(R.id.phoneValue);
        
        // Get the data item
        DataItem item = data.get(position);
        
        // Display the data item's properties
        nameText.setText(item.name);
        phoneText.setText(item.phoneNumber);
        
        return view;
    }

}
