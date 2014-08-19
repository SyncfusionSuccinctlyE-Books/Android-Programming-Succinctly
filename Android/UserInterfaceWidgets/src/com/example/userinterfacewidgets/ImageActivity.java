package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;

public class ImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		// Dynamically load an image into an ImageView
		ImageView imageView = (ImageView) findViewById(R.id.dynamicImage);
		Resources resources = getResources();
		Drawable image = resources.getDrawable(R.drawable.syncfusion_alt_icon);
		imageView.setImageDrawable(image);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

}
