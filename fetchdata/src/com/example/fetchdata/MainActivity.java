package com.example.fetchdata;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;
//import com.example.listview.R;
//import com.example.listview.R;
//import android.view.ViewGroup;
//import com.example.graph.R;
//import com.example.dslapp.R;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = " com.example.dslapp.MESSAGE";
	public static final String MyPREFERENCES = "MyPrefs";
	EditText etext;
	public static final String Etext = "etextkey";
	String message;
	SharedPreferences sharedpreferences;
	RelativeLayout layout2;
	// LinearLayout layout2;
	LinearLayout layout1;
	ScrollView layout3;
	TextView uiUpdate;
	String OutputData = "";
	String OutputData1 = "";
	String OutputData2 = "";
	String OutputData3 = "";
	String OutputData4 = "";
	String OutputData5 = "";
	double[] max;
	double[] min;
	double[] avg;
	GraphView graphView;
	ListView listView;
	ArrayAdapter<String> adapter;
	String[] values;
	View footer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// uiUpdate = (TextView) findViewById(R.id.output);
		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		String value = sharedpreferences.getString(Etext, null);
		etext = (EditText) findViewById(R.id.edit_message);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		// layout3 = (ScrollView) findViewById(R.id.layout3);
		layout2 = (RelativeLayout) findViewById(R.id.layout2);
		graphView = new LineGraphView(this, "Price Trend");

		listView = (ListView) findViewById(R.id.listView1);

		LayoutInflater inflater = getLayoutInflater();
		footer = (View) inflater.inflate(R.layout.footer, null, true);

		listView.addFooterView(footer);
		// String OutputData1 = "jegueububwbuegbuobg";
		// String OutputData2 = "rnhonowranhwroinioan";
		// String OutputData3 = "jegunegoineoin[nnon";
		// String OutputData4 = "aonfoinmmoijfq ieoei";
		// String OutputData5 = "dmgniwognoingonnwgono";

		// if (value == null) {

		layout1.setVisibility(View.VISIBLE);
		layout2.setVisibility(View.GONE);
		// layout2.setVisibility(View.GONE);
		// message = etext.getText().toString();
		// else {
		// TextView textView = new TextView(this);
		// textView.setTextSize(30);
		// setContentView(R.layout.activity_main);

		// layout1.setVisibility(View.GONE);
		// layout3.setVisibility(View.VISIBLE);

		// uiUpdate.setText(value);

		// layout2.setText(value);
		// textView.setText(value);
		// setContentView(textView);

		// final Button GetServerData=(Button) findViewById(R.id.GetServerData);
		// GetServerData.setOnClickListener(new OnClickListener()
		// { public void onClick(View v){
		// String serverUrl="http://10.1.9.14:8000/api?polygon_id=1381881";
		// new LongOperation().execute(serverUrl);
		// }
		// });
		// }
	}

	public void sendMessage(View view) {
		// String message = etext.getText().toString();
		// Editor editor = sharedpreferences.edit();
		// editor.putString(Etext, message);
		// editor.commit();
		layout1.setVisibility(View.GONE);
		layout2.setVisibility(View.VISIBLE);

		// layout2.setVisibility(View.VISIBLE);
		String serverUrl = "http://10.1.9.14:8000/api?polygon_id=70";
		new LongOperation().execute(serverUrl);
	}

	private class LongOperation extends AsyncTask<String, Void, Void> {
		private final HttpClient Client = new DefaultHttpClient();
		private String Content;
		private String Error = null;
		private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);

		// TextView uiUpdate = (TextView) findViewById(R.id.output);
		protected void onPreExecute() {
			// uiUpdate.setText("Output : ");
			Dialog.setMessage("Wait.....");
			Dialog.show();
		}

		protected Void doInBackground(String... urls) {
			try {
				HttpGet httpget = new HttpGet(urls[0]);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				Content = Client.execute(httpget, responseHandler);
			} catch (ClientProtocolException e) {
				Error = e.getMessage();
				cancel(true);
			} catch (IOException e) {
				Error = e.getMessage();
				cancel(true);
			}

			return null;
		}

		protected void onPostExecute(Void unused) {

			Dialog.dismiss();

			if (Error != null) {

				uiUpdate.setText("Output : " + Error);

			} else {

				// uiUpdate.setText("Output : "+Content);
				// String OutputData="";

				JSONObject jsonResponse1;
				JSONObject jsonResponse2;
				JSONObject jsonResponse3;
				JSONObject jsonResponse5;
				JSONObject jsonResponse6;
				JSONObject jsonResponse7;
				JSONObject jsonResponse8;
				JSONObject jsonResponse9;
				JSONObject jsonResponse10;

				JSONObject jsonResponse11;
				JSONObject jsonResponse12;
				JSONObject jsonResponse13;
				JSONObject jsonResponse14;
				JSONObject jsonResponse15;
				JSONObject jsonResponse16;
				JSONObject jsonResponse17;
				try {
					jsonResponse1 = new JSONObject(Content);

					jsonResponse15 = jsonResponse1
							.optJSONObject("demand_supply");
					jsonResponse16 = jsonResponse15.optJSONObject("buy");
					jsonResponse17 = jsonResponse15.optJSONObject("rent");
					JSONObject jsonChildNode6 = jsonResponse16
							.getJSONObject("demand");
					JSONObject jsonChildNode7 = jsonResponse16
							.getJSONObject("supply");
					int demand_4BHK = jsonChildNode6.optInt("3+ BHK", 0);
					int supply_4BHK = jsonChildNode7.optInt("3+ BHK", 0);
					int demand_3BHK = jsonChildNode6.optInt("3 BHK", 0);
					int supply_3BHK = jsonChildNode7.optInt("3 BHK", 0);
					int demand_2BHK = jsonChildNode6.optInt("2 BHK", 0);
					int supply_2BHK = jsonChildNode7.optInt("2 BHK", 0);
					int demand_1BHK = jsonChildNode6.optInt("1 BHK", 0);
					int supply_1BHK = jsonChildNode7.optInt("1 BHK", 0);
					int demand_1RK = jsonChildNode6.optInt("1 RK", 0);
					int supply_1RK = jsonChildNode7.optInt("1 RK", 0);
					OutputData1 += "\n" + "Demand and Supply for Buy" + "\n\n";
					OutputData1 += "3+ BHK: " + demand_4BHK + " " + supply_4BHK
							+ "\n";
					OutputData1 += "3 BHK: " + demand_3BHK + " " + supply_3BHK
							+ "\n";
					OutputData1 += "2 BHK: " + demand_2BHK + " " + supply_2BHK
							+ "\n";
					OutputData1 += "1 BHK: " + demand_1BHK + " " + supply_1BHK
							+ "\n";
					OutputData1 += "1 RK: " + demand_1RK + " " + supply_1RK
							+ "\n\n\n";

					JSONObject jsonChildNode8 = jsonResponse17
							.getJSONObject("demand");
					JSONObject jsonChildNode9 = jsonResponse17
							.getJSONObject("supply");
					int demand_4BHK1 = jsonChildNode8.optInt("3+ BHK", 0);
					int supply_4BHK1 = jsonChildNode9.optInt("3+ BHK", 0);
					int demand_3BHK1 = jsonChildNode8.optInt("3 BHK", 0);
					int supply_3BHK1 = jsonChildNode9.optInt("3 BHK", 0);
					int demand_2BHK1 = jsonChildNode8.optInt("2 BHK", 0);
					int supply_2BHK1 = jsonChildNode9.optInt("2 BHK", 0);
					int demand_1BHK1 = jsonChildNode8.optInt("1 BHK", 0);
					int supply_1BHK1 = jsonChildNode9.optInt("1 BHK", 0);
					int demand_1RK1 = jsonChildNode8.optInt("1 RK", 0);
					int supply_1RK1 = jsonChildNode9.optInt("1 RK", 0);
					OutputData2 += "\n" + "Demand and Supply for Rent" + "\n\n";
					OutputData2 += "3+ BHK: " + demand_4BHK1 + " "
							+ supply_4BHK1 + "\n";
					OutputData2 += "3 BHK: " + demand_3BHK1 + " "
							+ supply_3BHK1 + "\n";
					OutputData2 += "2 BHK: " + demand_2BHK1 + " "
							+ supply_2BHK1 + "\n";
					OutputData2 += "1 BHK: " + demand_1BHK1 + " "
							+ supply_1BHK1 + "\n";
					OutputData2 += "1 RK: " + demand_1RK1 + " " + supply_1RK1
							+ "\n\n\n";

					jsonResponse2 = jsonResponse1.optJSONObject("peripheral");
					jsonResponse3 = jsonResponse2
							.optJSONObject("places_to_see");
					JSONArray jsonMainNode = jsonResponse3
							.optJSONArray("results");
					int lengthJsonArr = jsonMainNode.length();
					OutputData3 += "Peripherals" + "\n\n";
					OutputData3 += "Good Places to See" + "\n";
					for (int i = 0; i < lengthJsonArr; i++) {
						JSONObject jsonChildNode = jsonMainNode
								.getJSONObject(i);
						String name = jsonChildNode.optString("name")
								.toString();
						double latitude = jsonChildNode.getDouble("latitude");
						double longitude = jsonChildNode.getDouble("longitude");
						OutputData3 += "\n" + name + "  " + latitude + ","
								+ longitude + "\n";

					}
					// jsonResponse4 =new JSONObject(Content);
					jsonResponse5 = jsonResponse2.optJSONObject("theaters");
					jsonResponse6 = jsonResponse5.optJSONObject("results");
					int num_theters = jsonResponse6.getInt("num_theaters");
					JSONArray jsonMainNode1 = jsonResponse6
							.optJSONArray("top_theaters");
					int lengthJsonArr1 = jsonMainNode1.length();
					OutputData3 += "\n\n" + "Top Theaters" + "\n\n";
					OutputData3 += "Number of Top Theatres: " + num_theters
							+ "\n";
					for (int i = 0; i < lengthJsonArr1; i++) {
						JSONObject jsonChildNode1 = jsonMainNode1
								.getJSONObject(i);
						String name1 = jsonChildNode1.optString("name")
								.toString();
						double latitude1 = jsonChildNode1.getDouble("latitude");
						double longitude1 = jsonChildNode1
								.getDouble("longitude");
						OutputData3 += "\n" + name1 + "  " + latitude1 + ","
								+ longitude1 + "\n";

					}
					jsonResponse7 = jsonResponse2.optJSONObject("restaurants");
					jsonResponse8 = jsonResponse7.optJSONObject("results");
					int num_restaurants = jsonResponse8
							.getInt("num_restaurants");
					JSONArray jsonMainNode2 = jsonResponse8
							.optJSONArray("top_restaurants");
					int lengthJsonArr2 = jsonMainNode2.length();
					OutputData3 += "\n\n" + "Top Restaurants" + "\n\n";
					OutputData3 += "Number of Restaurants: " + num_restaurants
							+ "\n";
					for (int i = 0; i < lengthJsonArr2; i++) {
						JSONObject jsonChildNode2 = jsonMainNode2
								.getJSONObject(i);
						String name2 = jsonChildNode2.optString("name")
								.toString();
						double score = jsonChildNode2.getDouble("score");
						double latitude2 = jsonChildNode2.getDouble("latitude");
						double longitude2 = jsonChildNode2
								.getDouble("longitude");
						OutputData3 += "\n" + name2 + "  " + score + "  "
								+ latitude2 + "," + longitude2 + "\n";

					}

					jsonResponse11 = jsonResponse1.optJSONObject("transport");
					jsonResponse12 = jsonResponse11
							.optJSONObject("local_train");
					OutputData4 += "\n\n" + "Transport" + "\n\n";
					JSONObject jsonChildNode3 = jsonResponse12
							.getJSONObject("results");
					String station_name = jsonChildNode3
							.getString("station_name");
					double distance = jsonChildNode3.getDouble("distance");
					String network_name = jsonChildNode3
							.getString("network_name");
					String line_name = jsonChildNode3.getString("line_name");
					OutputData4 += "\n" + "Nearby Local Train Station: "
							+ station_name + "  " + distance + "  "
							+ network_name + "  " + line_name + "\n";

					jsonResponse13 = jsonResponse11.optJSONObject("airport");
					JSONObject jsonChildNode4 = jsonResponse13
							.getJSONObject("results");
					String airport_name = jsonChildNode4.getString("name");
					double airport_distance = jsonChildNode4
							.getDouble("distance");
					OutputData4 += "\n" + "Nearby Airport: " + airport_name
							+ "  " + airport_distance + "\n";

					jsonResponse14 = jsonResponse11
							.optJSONObject("interstate_train");
					JSONObject jsonChildNode5 = jsonResponse14
							.getJSONObject("results");
					String interstate_name = jsonChildNode5.getString("name");
					double interstate_distance = jsonChildNode5
							.getDouble("distance");
					OutputData4 += "\n" + "Nearby Interstate Train Station: "
							+ interstate_name + "  " + interstate_distance
							+ "\n";

					jsonResponse9 = jsonResponse1.optJSONObject("price_trend");
					jsonResponse10 = jsonResponse9.optJSONObject("results");
					String start_date = jsonResponse10.getString("start_date");
					OutputData5 += "\n\n" + "Starting Date for Graph Data: "
							+ start_date + "\n\n";
					JSONArray jsonMainNode3 = jsonResponse10
							.optJSONArray("max");
					int lengthJsonArr3 = jsonMainNode3.length();
					max = new double[lengthJsonArr3];
					// OutputData+="\n"+"Maximum Price"+"\n";
					for (int i = 0; i < lengthJsonArr3; i++) {
						double price = jsonMainNode3.getDouble(i);
						// OutputData+="\n"+price+"\n";
						max[i] = price;
					}

					JSONArray jsonMainNode4 = jsonResponse10
							.optJSONArray("min");
					int lengthJsonArr4 = jsonMainNode4.length();
					min = new double[lengthJsonArr4];
					// OutputData+="\n"+"Minimum Price"+"\n";
					for (int i = 0; i < lengthJsonArr4; i++) {
						double price = jsonMainNode4.getDouble(i);
						// OutputData+="\n"+price+"\n";
						min[i] = price;
					}

					JSONArray jsonMainNode5 = jsonResponse10
							.optJSONArray("avg");
					int lengthJsonArr5 = jsonMainNode5.length();
					avg = new double[lengthJsonArr5];
					// OutputData+="\n"+"Average Price"+"\n";
					for (int i = 0; i < lengthJsonArr5; i++) {
						double price = jsonMainNode5.getDouble(i);
						// OutputData+="\n"+price+"\n";
						avg[i] = price;
					}

					/*
					 * Editor editor = sharedpreferences.edit();
					 * editor.putString(Etext, OutputData); editor.commit();
					 * uiUpdate.setText(OutputData);
					 */

					values = new String[] { OutputData1, OutputData2,
							OutputData3, OutputData4, OutputData5 };

					GraphViewDataInterface[] data = new GraphViewData[lengthJsonArr3];
					for (int i = 0; i < lengthJsonArr3; i++) {
						data[i] = new GraphViewData(i + 1, max[i]);
					}

					GraphViewDataInterface[] data1 = new GraphViewData[lengthJsonArr4];
					for (int i = 0; i < lengthJsonArr4; i++) {
						data1[i] = new GraphViewData(i + 1, min[i]);
					}

					GraphViewDataInterface[] data2 = new GraphViewData[lengthJsonArr5];
					for (int i = 0; i < lengthJsonArr5; i++) {
						data2[i] = new GraphViewData(i + 1, avg[i]);
					}
					//GraphViewSeriesStyle   color1=new GraphViewStyle(Color.GREEN,3,0);
					GraphViewSeries Series1 = new GraphViewSeries("Maximum Price",new GraphViewSeriesStyle(Color.CYAN,3),data);
					GraphViewSeries Series2 = new GraphViewSeries("Minimum Price",new GraphViewSeriesStyle(Color.GREEN,3),data1);
					GraphViewSeries Series3 = new GraphViewSeries("Average Price",new GraphViewSeriesStyle(Color.MAGENTA,3),data2);
					((LineGraphView) graphView).setDrawDataPoints(true);
					((LineGraphView) graphView).setDataPointsRadius(5f);
					graphView.addSeries(Series1);
					graphView.addSeries(Series2);
					graphView.addSeries(Series3);
					graphView.setShowLegend(true);
					Editor editor = sharedpreferences.edit();
					editor.putString(Etext, OutputData);
					editor.commit();
					// uiUpdate.setText(OutputData5);

					
					graphView.getGraphViewStyle().setHorizontalLabelsColor(
							Color.BLACK);
					graphView.getGraphViewStyle().setVerticalLabelsColor(
							Color.BLACK);
					graphView.getGraphViewStyle().setTextSize(10);
					graphView.getGraphViewStyle().setNumVerticalLabels(15);
					graphView.getGraphViewStyle().setNumHorizontalLabels(21);
					//graphView.getGraphViewStyle().setGridColor(12);
					//graphView.setScrollable(true);

					RelativeLayout layout = (RelativeLayout) footer
							.findViewById(R.id.trendsGraph);

					AbsListView.LayoutParams params = new AbsListView.LayoutParams(
							getWindowManager().getDefaultDisplay().getWidth(),
							700);
					layout.setLayoutParams(params);
					layout.addView(graphView);

					listView.addFooterView(layout);
					/*
					 * LinearLayout layout=new LinearLayout(this);
					 * 
					 * RelativeLayout.LayoutParams params = new
					 * RelativeLayout.LayoutParams(
					 * getWindowManager().getDefaultDisplay().getWidth(), 400);
					 * params.addRule(RelativeLayout.BELOW, R.id.listView1);
					 * layout.setLayoutParams(params);
					 * layout.addView(graphView);
					 */

					// OutputData1 = "jegueububwbuegbuobg";
					// OutputData2 = "rnhonowranhwroinioan";
					// OutputData3 = "jegunegoineoin[nnon";
					// OutputData4 = "aonfoinmmoijfq ieoei";
					// OutputData5 = "dmgniwognoingonnwgono";

					adapter = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1,
							android.R.id.text1, values);

					listView.setAdapter(adapter);
				}

				/*	listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {

							int itemPosition = position;
							String itemValue = (String) listView
									.getItemAtPosition(position);
							Toast.makeText(
									getApplicationContext(),
									"Position :" + itemPosition
											+ "  ListItem : " + itemValue,
									Toast.LENGTH_LONG).show();

						}

					});

				}*/

				catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
