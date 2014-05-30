package com.example.androidsqliteproject;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MainActivity extends ListActivity {
	private StudentOperations studentDBoperation;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		studentDBoperation=new StudentOperations(this);
		studentDBoperation.open();
		List values=studentDBoperation.getAllStudents();
		
		ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,values);
		setListAdapter(adapter);
		
		
	}
	
	public void addUser(View view)
	{
		ArrayAdapter adapter=(ArrayAdapter) getListAdapter();
		EditText text=(EditText) findViewById(R.id.editText1);
		Student stud=studentDBoperation.addStudent(text.getText().toString());
		text.setText("");
		adapter.add(stud);
	}
	
	public void deleteLastUser(View view)
	{
		ArrayAdapter adapter=(ArrayAdapter) getListAdapter();
		Student stud=null;
		int num=getListAdapter().getCount();
		if(getListAdapter().getCount()>0)
		{
			stud=(Student) getListAdapter().getItem(num-1);
			studentDBoperation.deleteStudent(stud);
			adapter.remove(stud);
		}
	}
	
	public void deleteFirstUser(View view)
	{
		ArrayAdapter adapter=(ArrayAdapter) getListAdapter();
		Student stud=null;
		//int num=getListAdapter().getCount();
		if(getListAdapter().getCount()>0)
		{
			stud=(Student) getListAdapter().getItem(0);
			studentDBoperation.deleteStudent(stud);
			adapter.remove(stud);
		}
	}
	
	
	@Override
	public void onResume()
	{
		studentDBoperation.open();
		super.onResume();
		
	}
	
	@Override
	public void onPause()
	{
		studentDBoperation.close();
		super.onPause();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
