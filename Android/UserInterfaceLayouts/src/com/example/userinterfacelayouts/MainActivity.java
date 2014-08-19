package com.example.userinterfacelayouts;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import java.util.ArrayList;

import com.example.userinterfacelayouts.CustomAdapter;
import com.example.userinterfacelayouts.DataItem;

public class MainActivity extends Activity {
	
	private ArrayList<DataItem> data;
	private CustomAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    this.data = new ArrayList<DataItem>();
	    this.data.add(new DataItem("John Smith", "(555) 454-5545"));
	    this.data.add(new DataItem("Mary Johnson", "(555) 665-5665"));
	    this.data.add(new DataItem("Bill Kim", "(555) 446-4464"));
	    
	    adapter = new CustomAdapter(this, data);
	    ListView listView = (ListView) findViewById(R.id.listView);
	    listView.setAdapter(adapter);
	}
}

