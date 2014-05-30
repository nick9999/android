package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView listView;
	//View footer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setContentView(R.layout.footer);
		listView = (ListView) findViewById(R.id.listView1);
		String OutoutData1 = "jegueububwbuegbuobg";
		String OutoutData2 = "rnhonowranhwroinioan";
		String OutoutData3 = "jegunegoineoin[nnon";
		String OutoutData4 = "aonfoinmmoijfq ieoei";
		String OutoutData5 = "dmgniwognoingonnwgono";
		String[] values = new String[] { OutoutData1, OutoutData2, OutoutData3,
				OutoutData4, OutoutData5,OutoutData1, OutoutData2, OutoutData3,
				OutoutData4, OutoutData5,OutoutData1, OutoutData2, OutoutData3,
				OutoutData4, OutoutData5 };
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, listView,
                false);
		listView.addFooterView(footer, null, false);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);
		 

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				int itemPosition = position;
				String itemValue = (String) listView
						.getItemAtPosition(position);
				Toast.makeText(
						getApplicationContext(),
						"Position :" + itemPosition + "  ListItem : "
								+ itemValue, Toast.LENGTH_LONG).show();

			}

		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
