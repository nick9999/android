package com.example.androidsqliteproject;

public class Student {
	private long id;
	private String name;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
}
