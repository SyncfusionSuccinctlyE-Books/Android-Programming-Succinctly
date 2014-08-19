package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;
import android.util.TypedValue;

public class CheckBoxActivity extends Activity {
	
	private boolean isGreen;
	private boolean isBold;
	private boolean isBig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box);
		
		this.isGreen = true;
		this.isBold = false;
		this.isBig = false;
		
		synchronizeCheckBoxes();
		synchronizeTextView();
	}
	
	private void synchronizeCheckBoxes() {
		CheckBox green = (CheckBox) findViewById(R.id.checkBoxGreen);
		CheckBox bold = (CheckBox) findViewById(R.id.checkBoxBold);
		CheckBox big = (CheckBox) findViewById(R.id.checkBoxBig);
		
		green.setChecked(this.isGreen);
		bold.setChecked(this.isBold);
		big.setChecked(this.isBig);
	}
	
	private void synchronizeTextView() {
		TextView text = (TextView) findViewById(R.id.checkBoxText);
		if (this.isGreen) {
			text.setTextColor(Color.parseColor("#FF009900"));
		} else {
			text.setTextColor(Color.parseColor("#FF000000"));
		}
		if (this.isBold) {
			text.setTypeface(Typeface.create("default", Typeface.BOLD));
		} else {
			text.setTypeface(Typeface.create("default", Typeface.NORMAL));
		}
		if (this.isBig) {
			text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		} else {
			text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		}
	}
	
	
	public void checkBoxClicked(View view) {
		CheckBox checkbox = (CheckBox) view;
		boolean isChecked = checkbox.isChecked();
		switch (view.getId()) {
			case R.id.checkBoxGreen:
				this.isGreen = isChecked;
				break;
			case R.id.checkBoxBold:
				this.isBold = isChecked;
				break;
			case R.id.checkBoxBig:
				this.isBig = isChecked;
				break;
		}
		synchronizeTextView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_box, menu);
		return true;
	}

}
