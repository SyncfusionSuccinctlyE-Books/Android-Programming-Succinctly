package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class ButtonActivity extends Activity {
	
	private static String TAG = "ButtonActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		
		Button button = (Button) findViewById(R.id.textImageButton);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View sender) {
				Button senderAsButton = (Button) sender;
				String title = (String) senderAsButton.getText();
				Log.d(TAG, String.format("You clicked the '%s' button", title));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.button, menu);
		return true;
	}

}
