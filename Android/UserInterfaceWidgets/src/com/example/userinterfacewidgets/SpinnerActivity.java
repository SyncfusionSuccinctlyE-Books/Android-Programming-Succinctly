package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import android.util.Log;

public class SpinnerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		
		/*
		// Define the spinner items
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
	    colors.add("Orange");
	    colors.add("Yellow");
	    colors.add("Green");
	    colors.add("Blue");
	    colors.add("Violet");
	    
	    // Create an adapter
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	    		android.R.layout.simple_spinner_item,
	    		colors);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    */
	    
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	    		R.array.spinnerColors,
	    		android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    
	    // Give the adapter to the spinner
	    Spinner spinner = (Spinner) findViewById(R.id.colorSpinner);
	    spinner.setAdapter(adapter);
	    
	    // Handle click events
	    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	        public void onItemSelected(AdapterView<?> parent, View v,
                                    int position, long id) {
	        	String selectedColor = (String) parent.getItemAtPosition(position);
	        	setTextColor(selectedColor);
	        }
	        
	        public void onNothingSelected(AdapterView<?> parent) {
	        	// Called when the selection disappears
	        }
	    });
	}
	
	private void setTextColor(String color) {
		String hexColor = "#FF000000";
		if (color.equals("Red")) {
			hexColor = "#FFAA0000";
		} else if (color.equals("Orange")) {
			hexColor = "#FFCC6600";
		}  else if (color.equals("Yellow")) {
			hexColor = "#FFCCAA00";
		}  else if (color.equals("Green")) {
			hexColor = "#FF00AA00";
		}  else if (color.equals("Blue")) {
			hexColor = "#FF0000AA";
		}  else if (color.equals("Violet")) {
			hexColor = "#FF6600AA";
		} 
		
		TextView text = (TextView) findViewById(R.id.spinnerText);
		text.setTextColor(Color.parseColor(hexColor));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner, menu);
		return true;
	}

}
