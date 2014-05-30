package com.example.androidsqliteproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {
	public static final String students="Students";
	public static final String student_id="id";
	public static final String student_name="name";
	
	private static final String database_name="Students.db";
	private static final int database_version=1;
	
	public static final String database_create="create table "+students+"("+
												student_id+" INTEGER PRIMARY KEY AUTOINCREMENT , "
												+student_name+"  VARCHAR(30) NOT NULL);";
	
	public DataBaseWrapper(Context context)
	{
		super(context,database_name,null,database_version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(database_create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists"+ students);
		onCreate(db);
	}

}
