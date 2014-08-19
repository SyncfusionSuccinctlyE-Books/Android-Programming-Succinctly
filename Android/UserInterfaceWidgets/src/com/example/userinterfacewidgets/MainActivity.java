package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends Activity {
	
	private static String IMAGES_TAG = "images";
	private static String BUTTONS_TAG = "buttons";
	private static String TEXT_FIELDS_TAG = "textFields";
	private static String CHECK_BOXES_TAG = "checkBoxes";
	private static String RADIO_BUTTONS_TAG = "radioButtons";
	private static String SPINNERS_TAG = "spinners";
	private static String PICKERS_TAG = "pickers";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void selectActivity(View view) {
		Intent intent = new Intent();
		String tag = (String) view.getTag();
		if (tag.equals(IMAGES_TAG)) {
			intent.setClass(this, ImageActivity.class);
		} else if (tag.equals(BUTTONS_TAG)) {
			intent.setClass(this, ButtonActivity.class);
		} else if (tag.equals(TEXT_FIELDS_TAG)) {
			intent.setClass(this, TextFieldActivity.class);
		} else if (tag.equals(CHECK_BOXES_TAG)) {
			intent.setClass(this, CheckBoxActivity.class);
		} else if (tag.equals(RADIO_BUTTONS_TAG)) {
			intent.setClass(this, RadioButtonActivity.class);
		} else if (tag.equals(SPINNERS_TAG)) {
			intent.setClass(this, SpinnerActivity.class);
		} else if (tag.equals(PICKERS_TAG)) {
			intent.setClass(this, PickerActivity.class);
		}
		
		startActivity(intent);
	}

}
