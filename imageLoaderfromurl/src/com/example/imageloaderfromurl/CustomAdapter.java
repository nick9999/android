package com.example.imageloaderfromurl;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
	
	private Activity activity;
	private ArrayList<String> data;
	private static LayoutInflater inflater=null;
	public ImageLoader imageloader;
	int loader=R.drawable.ic_launcher;
	
	public CustomAdapter(Activity a,ArrayList<String> d)
	{
		data=d;
		activity=a;
		imageloader=new ImageLoader(activity.getApplicationContext());
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v=convertView;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_row,null);
		}
		ImageView image=(ImageView) v.findViewById(R.id.image);
		String url;
		url=data.get(position);
		imageloader.DisplayImage(url, loader, image);
		
		return v;
	}
	
	
}
