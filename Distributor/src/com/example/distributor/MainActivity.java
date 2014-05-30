package com.example.distributor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
	private Spinner spinner;
	private static final String[] names = { "Bandra", "Thane", "Andheri",
			"Dadar" };
	TextView textView1;
	TextView textView2;
	LinearLayout layout1 ;
	LinearLayout layout2;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout1=(LinearLayout) findViewById(R.id.layout1);
		layout2=(LinearLayout) findViewById(R.id.layout2);
		layout=(LinearLayout)  findViewById(R.id.layout);
		//layout1.setVisibility(View.VISIBLE);
		//layout2.setVisibility(View.GONE);
		
		layout.setBackgroundColor(Color.YELLOW);
		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_spinner_item, names);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		//layout1.setVisibility(View.GONE);
		//layout2.setVisibility(View.VISIBLE);
		textView2=(TextView) findViewById(R.id.textView2);
		switch (position) {
		case 0:
			String str01="Name11" +"\n"+"Rating"+"\n"+"Phone no "+"\n\n";
			String str02="Name21" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str03="Name31" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str04="Name41" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str05="Name51" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str0=str01+str02+str03+str04+str05;
			textView2.setText(str0);
			//Toast.makeText(MainActivity.this,str01+str02+str03+str04+str05,Toast.LENGTH_LONG).show();
			break;
		case 1:
			String str11="Name12" +"\n"+"Rating"+"\n"+"Phone no "+"\n\n";
			String str12="Name22" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str13="Name32" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str14="Name42" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str15="Name52" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str1=str11+str12+str13+str14+str15;
			textView2.setText(str1);
			//Toast.makeText(MainActivity.this,str11+str12+str13+str14+str15,Toast.LENGTH_LONG).show();
			break;
		case 2:
			String str21="Name13" +"\n"+"Rating"+"\n"+"Phone no "+"\n\n";
			String str22="Name23" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str23="Name33" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str24="Name43" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str25="Name53" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str2=str21+str22+str23+str24+str25;
			textView2.setText(str2);
			//Toast.makeText(MainActivity.this,str21+str22+str23+str24+str25,Toast.LENGTH_LONG).show();
			break;
		case 3:
			String str31="Name14" +"\n"+"Rating"+"\n"+"Phone no "+"\n\n";
			String str32="Name24" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str33="Name34" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str34="Name44" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str35="Name54" +"\n"+"Rating "+"\n"+"Phone no "+"\n\n";
			String str3=str31+str32+str33+str34+str35;
			textView2.setText(str3);
			//Toast.makeText(MainActivity.this,str31+str32+str33+str34+str35,Toast.LENGTH_LONG).show();
			
			break;

		}
		
	}	
		  public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		  }
		 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
