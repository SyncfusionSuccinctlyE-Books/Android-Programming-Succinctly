package com.example.userinterfacewidgets;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.DatePicker;

public class PickerActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {
	
	private static String TAG = "PickerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picker);
	}
	
	public void showDatePickerDialog(View view) {
		DialogFragment picker = new DatePickerFragment();
		picker.show(getSupportFragmentManager(), "datePicker");
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		// Process the selected date (month is zero-indexed)
		TextView text = (TextView) findViewById(R.id.pickerText);
		String message = String.format("Selected date: %d/%d/%d", month+1, day, year);
		text.setText(message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.picker, menu);
		return true;
	}

}
