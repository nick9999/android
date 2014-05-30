package com.example.androidsqliteproject;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentOperations {

	private DataBaseWrapper dbHelper;
	private String[] student_table_columns = { DataBaseWrapper.student_id,
			DataBaseWrapper.student_name };
	private SQLiteDatabase database;

	public StudentOperations(Context context) {
		dbHelper = new DataBaseWrapper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Student addStudent(String name) {
		ContentValues values = new ContentValues();
		values.put(DataBaseWrapper.student_name, name);
		long stuId = database.insert(DataBaseWrapper.students, null, values);

		Cursor cursor = database.query(DataBaseWrapper.students,
				student_table_columns, DataBaseWrapper.student_id + " = "
						+ stuId, null, null, null, null);

		cursor.moveToFirst();
		Student newComment = parseStudent(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteStudent(Student comment) {
		long id = comment.getId();
		System.out.println("Student deleted with id: " + id);

		database.delete(DataBaseWrapper.students, DataBaseWrapper.student_id
				+ "=" + id, null);
	}

	public List getAllStudents() {
		List students = new ArrayList();

		Cursor cursor = database.query(DataBaseWrapper.students,
				student_table_columns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Student student =  parseStudent(cursor);
			students.add(student);
			cursor.moveToNext();
		}
		cursor.close();
		return students;
	}

	private Student parseStudent(Cursor cursor) {
		Student student = new Student();
		student.setId(cursor.getLong(0));
		student.setName(cursor.getString(1));
		return student;
	}
}
