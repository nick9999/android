package com.example.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] names;
	private final int[] imageid;

	public CustomList(Activity context, String[] names, int[] imageid)
	{
		super(context, R.layout.list_single, names);
		this.context = context;
		this.names = names;
		this.imageid = imageid;

	}
	
	public View getView(int position,View view, ViewGroup parent)
	{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.list_single, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		txtTitle.setText(names[position]);
		imageView.setImageResource(imageid[position]);
		return rowView;
	}
}
