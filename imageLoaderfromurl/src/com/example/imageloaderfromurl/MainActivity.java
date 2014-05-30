package com.example.imageloaderfromurl;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int loader = R.drawable.ic_launcher;
		ImageView image = (ImageView) findViewById(R.id.image);
		String image_url1 = "http://api.androidhive.info/images/sample.jpg";
		String image_url2 = "http://s3.amazonaws.com/thumbnails.illustrationsource.com/huge.86.433302.JPG";
		ImageLoader imgLoader = new ImageLoader(getApplicationContext());
		
		
		//imgLoader.DisplayImage(image_url1, loader, image);
		//imgLoader.DisplayImage(image_url2, loader, image);

	}
	
	public class CustomAdapter extends BaseAdapter
	{
		private Activity activity;
		private ArrayList data;
		private static LayoutInflater inflater=null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
