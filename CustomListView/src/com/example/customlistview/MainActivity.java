package com.example.customlistview;

//import com.example.distributor.MainActivity;

//import com.example.distributor.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {
	ListView list;
	private Spinner spinner;
	private static final String[] names = { "Bandra", "Thane", "Andheri",
			"Dadar" };
	String[] name;
	int[] imageid;
	LinearLayout layout;
	LinearLayout layout1;
	LinearLayout layout2;

	/*
	 * String [] name={"dajnfjkn", "anfonoan", "ifnonon"}; int[]
	 * imageid={R.drawable.phone,R.drawable.phone,R.drawable.phone};
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (LinearLayout) findViewById(R.id.layout);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		layout.setBackgroundColor(Color.parseColor("#ffcc00"));

		// layout1.setVisibility(View.VISIBLE);
		// layout2.setVisibility(View.GONE);
		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_spinner_item, names);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

	}

	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {

		// layout1.setVisibility(View.GONE);
		// layout2.setVisibility(View.VISIBLE);

		switch (position) {
		case 0:
			String str00="\t\t"+"Bansra  post1 office"+"\n"+"Beside Bhabha Hospital R K Patkar marg"+
					"\n"+"Bandra West 400050"+"\n"+"Ph.No. 02226418635";
			String str01 = "\t\t\t" + "	A.H. Joshi" + "\t\t\t" + "8.9" + "\n\n"
					+ "  9897623487 " + "\n\n";
			String str02 = "\t\t\t" + "P.F. Patil" + "\t\t\t" + "8.2 " + "\n\n"
					+ "  9786535424 " + "\n\n";
			String str03 = "\t\t\t" + "Shyam Mehta" + "\t\t\t" + "7.8 " + "\n\n"
					+ "  9764539824 " + "\n\n";
			String str04 = "\t\t\t" + "Shama Patel" + "\t\t\t" + "7.5 " + "\n\n"
					+ "  9987456387 " + "\n\n";
			String str05 = "\t\t\t" + "Dhiman  Gupta" + "\t\t\t" + "7.1 " + "\n\n"
					+ "  9974533142 " + "\n\n";
			String[] name = { str00,str01, str02, str03, str04, str05 };
			int[] imageid = {R.drawable.post1,R.drawable.phone, R.drawable.phone,
					R.drawable.phone, R.drawable.phone, R.drawable.phone };
			CustomList adapter = new CustomList(MainActivity.this, name,
					imageid);
			list = (ListView) findViewById(R.id.list);
			list.setAdapter(adapter);

			// Toast.makeText(MainActivity.this,str01+str02+str03+str04+str05,Toast.LENGTH_LONG).show();
			break;
		case 1:
			String str10="\t\t"+"Thane head post1 office"+"\n"+"Opposite civil hospital,Thane west"+
					"\n"+"Thane 400601"+"\n"+"Ph.No. 02225476022";
			String str11 = "\t\t\t" + "Rakesh Sharma" + "\t\t\t" + "9.3" + "\n\n"
					+ "  9873425436 " + "\n\n";
			String str12 = "\t\t\t" + "Gaurav Chatterjee" + "\t\t\t" + "8.7 " + "\n\n"
					+ "  8985764736 " + "\n\n";
			String str13 = "\t\t\t" + "Subhash Dayal" + "\t\t\t" + "8.2 " + "\n\n"
					+ "  8954673654 " + "\n\n";
			String str14 = "\t\t\t" + "C. Shrikanth" + "\t\t\t" + "7.7 " + "\n\n"
					+ "  9984359845 " + "\n\n";
			String str15 = "\t\t\t" + "Sairaj Shah" + "\t\t\t" + "7.1 " + "\n\n"
					+ "  9873249871 " + "\n\n";
			String[] name1 = {str10, str11, str12, str13, str14, str15 };
			int[] imageid1 = { R.drawable.post1,R.drawable.phone, R.drawable.phone,
					R.drawable.phone, R.drawable.phone, R.drawable.phone };
			CustomList adapter1 = new CustomList(MainActivity.this, name1,
					imageid1);
			list = (ListView) findViewById(R.id.list);
			list.setAdapter(adapter1);

			// Toast.makeText(MainActivity.this,str11+str12+str13+str14+str15,Toast.LENGTH_LONG).show();
			break;
		case 2:
			String str20="\t\t"+"Andheri post1 office"+"\n"+"Andheri-kurla road ,JB nagar"+
					"\n"+"Andheri East 400059"+"\n"+"Ph.No. 022228328916";
			String str21 = "\t\t\t" + "D. M. Chaudhari" + "\t\t\t" + "9.4" + "\n\n"
					+ "  9703247861 " + "\n\n";
			String str22 = "\t\t\t" + "Arun Naik" + "\t\t\t" + "8.9" + "\n\n"
					+ "  9987564354" + "\n\n";
			String str23 = "\t\t\t" + "Neha Narayan" + "\t\t\t" + "8.5 " + "\n\n"
					+ "  9873452315 " + "\n\n";
			String str24 = "\t\t\t" + "Swati Lodha" + "\t\t\t" + "8.1 " + "\n\n"
					+ "  9945637923 " + "\n\n";
			String str25 = "\t\t\t" + "Suraj Patki" + "\t\t\t" + "7.6 " + "\n\n"
					+ "  9087249811 " + "\n\n";
			String[] name2 = { str20,str21, str22, str23, str24, str25 };
			int[] imageid2 = { R.drawable.post1,R.drawable.phone, R.drawable.phone,
					R.drawable.phone, R.drawable.phone, R.drawable.phone };
			CustomList adapter2 = new CustomList(MainActivity.this, name2,
					imageid2);
			list = (ListView) findViewById(R.id.list);
			list.setAdapter(adapter2);

			// Toast.makeText(MainActivity.this,str21+str22+str23+str24+str25,Toast.LENGTH_LONG).show();
			break;
		case 3:
			String str30="\t\t"+"Dadar post1 office"+"\n"+"Lokmanya Tilak colony"+
					"\n"+"Dadar 400014"+"\n"+"Ph.No. 02224168410";
			String str31 = "\t\t\t" + "Raj Mehra" + "\t\t\t" + "9.6" + "\n\n"
					+ "  9083344552 " + "\n\n";
			String str32 = "\t\t\t" + "Deep Mistry" + "\t\t\t" + "8.9 " + "\n\n"
					+ "  9873322772" + "\n\n";
			String str33 = "\t\t\t" + "Sonali More" + "\t\t\t" + "8.5 " + "\n\n"
					+ "  9702789895 " + "\n\n";
			String str34 = "\t\t\t" + "Parag Meena" + "\t\t\t" + "8.1" + "\n\n"
					+ "  9678544332" + "\n\n";
			String str35 = "\t\t\t" + "Kunal Modi" + "\t\t\t" + "7.6 " + "\n\n"
					+ "  8966574534 " + "\n\n";
			String[] name3 = {str30, str31, str32, str33, str34, str35 };
			int[] imageid3 = { R.drawable.post1,R.drawable.phone, R.drawable.phone,
					R.drawable.phone, R.drawable.phone, R.drawable.phone };
			CustomList adapter3 = new CustomList(MainActivity.this, name3,
					imageid3);
			list = (ListView) findViewById(R.id.list);
			list.setAdapter(adapter3);

			// Toast.makeText(MainActivity.this,str31+str32+str33+str34+str35,Toast.LENGTH_LONG).show();

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
