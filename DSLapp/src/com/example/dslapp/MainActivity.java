package com.example.dslapp;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = " com.example.dslapp.MESSAGE";
	public static final String MyPREFERENCES = "MyPrefs";
	EditText etext;
	public static final String Etext = "etextkey";
	String message;
	SharedPreferences sharedpreferences;
	LinearLayout layout2;
	LinearLayout layout1;
	ScrollView layout3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		String value = sharedpreferences.getString(Etext, null);
		etext = (EditText) findViewById(R.id.edit_message);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout3 = (ScrollView) findViewById(R.id.layout3);
		
		if (value == null) {

			layout1.setVisibility(View.VISIBLE);
			layout3.setVisibility(View.GONE);
			
			//message = etext.getText().toString();
		} else {
			// TextView textView = new TextView(this);
			// textView.setTextSize(30);
			// setContentView(R.layout.activity_main);
			TextView uiUpdate = (TextView) findViewById(R.id.output);
			layout1.setVisibility(View.GONE);
			layout3.setVisibility(View.VISIBLE);
			
			uiUpdate.setText(value);
			// layout2.setText(value);
			// textView.setText(value);
			// setContentView(textView);
		}
	}

	public void sendMessage(View view) {
		String message = etext.getText().toString();
		Editor editor = sharedpreferences.edit();
		editor.putString(Etext, message);
		editor.commit();
		TextView uiUpdate = (TextView) findViewById(R.id.output);
		layout1.setVisibility(View.GONE);
		layout3.setVisibility(View.VISIBLE);
		
		uiUpdate.setText(message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds itoutems to the action bar if it is
		// present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
