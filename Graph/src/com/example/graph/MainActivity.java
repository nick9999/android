package com.example.graph;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;



public class MainActivity extends Activity {
	private Interpolation interpolation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		double [] xvalues={1,2,3,4,5,6,7,8,9,10};
		double [] yvalues={15,36,5,47,28,37,79,24,20,65};
		
		 interpolation (xvalues,yvalues);
		

		/*GraphViewData[] data1 = new GraphViewData[22];
		for (int i = 0; i < 22; i++) {
			data1[i] = new GraphViewData(i + 1, i * 23.4 + 34);
		}

		GraphViewData[] data2 = new GraphViewData[22];
		for (int i = 0; i < 22; i++) {
			data2[i] = new GraphViewData(i + 1, i * 23.4 + 65);
		}*/

		GraphView graphView = new LineGraphView(this, "GraphView");
		((LineGraphView) graphView).setDrawDataPoints(true);
		((LineGraphView) graphView).setDataPointsRadius(5f);
		GraphViewSeries Series1 = new GraphViewSeries(data);
		//GraphViewSeries Series2 = new GraphViewSeries(data1);
		//GraphViewSeries Series3 = new GraphViewSeries(data2);
		graphView.addSeries(Series1);
		//graphView.addSeries(Series2);
		//graphView.addSeries(Series3);

		// GraphViewSeries exampleSeries = new GraphViewSeries(new
		// GraphViewData[] );
		// plot_graph graph=new plot_graph(this,xvalues,yvalues,1);
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
		layout.addView(graphView);

	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
