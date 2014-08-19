package com.example.helloandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	public static final String EXTRA_MESSAGE = "com.example.helloandroid.MESSAGE";

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
	
	public void nextPage(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		Button button = (Button)view;
		String message = button.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
