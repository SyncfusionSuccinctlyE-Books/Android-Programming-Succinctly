package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button);
		
		// Set the initial selection
		RadioButton serif = (RadioButton) findViewById(R.id.radioButtonSerif);
		serif.setChecked(true);
		radioButtonClicked(null);
	}
	
	public void radioButtonClicked(View view) {
		// Use the radio group to find the selected button
		RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
		String typeface;
		switch (group.getCheckedRadioButtonId()) {
			case R.id.radioButtonSans:
				typeface = "sans";
				break;
			case R.id.radioButtonSerif:
				typeface = "serif";
				break;
			case R.id.radioButtonMonospace:
				typeface = "monospace";
				break;
			default:
				typeface = "default";
		}
		TextView text = (TextView) findViewById(R.id.radioButtonText);
		text.setTypeface(Typeface.create(typeface, Typeface.NORMAL));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_button, menu);
		return true;
	}

}
