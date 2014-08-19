package com.example.applicationdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.EditText;
import android.util.Log;

import android.content.SharedPreferences;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {
	
	private static String SHARED_PREFS_KEY = "existingInput";
	private static String FILENAME = "someFile";
	private static String AUTHOR_NAME = "Bill";
	private static String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set up the EditText
		EditText prefsText = (EditText) findViewById(R.id.sharedPrefsText);
		prefsText.setOnEditorActionListener(new OnEditorActionListener() {
		    public boolean onEditorAction(TextView textView,
		                                  int actionId,
		                                  KeyEvent event) {
		    	String input = textView.getText().toString();
		    	
		    	//saveStringWithSharedPreferences(SHARED_PREFS_KEY, input);
		    	
		    	/*
		    	try {
					saveStringWithInternalStorage(FILENAME, input);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
		    	
		    	saveStringWithDatabase(input);
		    	

		        return false;
		    }
		});
		
		// Load the string from SharedPreferences
		/*
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		String existingInput = prefs.getString(SHARED_PREFS_KEY, "");
		prefsText.setText(existingInput);*/
		
		// Load the string from internal storage
		/*
		FileInputStream input = null;
		try {
			// Open the file
			input = openFileInput(FILENAME);
			// Read the byte data
			int maxBytes = input.available();
			byte[] data = new byte[maxBytes];
			input.read(data, 0, maxBytes);
			while (input.read(data) != -1) {};
			// Turn it into a String and display it
			String existingInput = new String(data);
			prefsText.setText(existingInput);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
		// Load the most recent record from the SQLite database
		MessageOpenHelper dbHelper = new MessageOpenHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();		
		// Fetch the records with the appropriate author name
		String[] columns = {MessageOpenHelper.COLUMN_ID,
							MessageOpenHelper.COLUMN_MESSAGE};
		String selection = MessageOpenHelper.COLUMN_AUTHOR + " = '" + AUTHOR_NAME + "'";
		Cursor cursor = db.query(MessageOpenHelper.TABLE_MESSAGES,
		        columns, selection, null, null, null, null);
		// Display the most recent record in the text field
		cursor.moveToLast();
		long id = cursor.getLong(0);
		String message = cursor.getString(1);
		Log.d(TAG, String.format("Retrieved info from database. ID: %d Message: %s", id, message));
		prefsText.setText(message);
		
		// Clean up
		cursor.close();
		dbHelper.close();
	}
	
	public void saveStringWithDatabase(String value) {
		// Store the author and message in a ContentValues object
		ContentValues values = new ContentValues();
		values.put(MessageOpenHelper.COLUMN_AUTHOR, AUTHOR_NAME);
		values.put(MessageOpenHelper.COLUMN_MESSAGE, value);
		
		// Record that ContentValues in a SQLite database 
		MessageOpenHelper dbHelper = new MessageOpenHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long id = db.insert(MessageOpenHelper.TABLE_MESSAGES, null, values);
		Log.d(TAG, String.format("Saved new record to database with ID: %d", id));
		dbHelper.close();
	}
	
	public void saveStringWithInternalStorage(String filename, String value) throws IOException {
		FileOutputStream output = openFileOutput(filename, MODE_PRIVATE);
		byte[] data = value.getBytes();
		output.write(data);
		output.close();
	}
	
	public void saveStringWithSharedPreferences(String key, String value) {
		// Get the SharedPreferences editor
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		
		// Save the string
		editor.putString(key,  value);
		
		// Commit the changes
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
