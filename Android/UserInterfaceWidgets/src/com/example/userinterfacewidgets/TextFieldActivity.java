package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.EditText;
import android.util.Log;
import android.content.Context;

public class TextFieldActivity extends Activity {
	
	private static String TAG = "ButtonActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_field);
		
		EditText text = (EditText) findViewById(R.id.textField);
		text.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {			
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					String input = textView.getText().toString();
					Log.d(TAG, String.format("SEND SEND SEND: %s", input));
					
					// Manually dismiss the keyboard
					InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
					return true;
				}
				return false;
	    	}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_field, menu);
		return true;
	}

}
