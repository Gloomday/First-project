package com.example.component.entity;

public class Record {
	private int id;
	private String title;
	
	public Record(){}
	
	public Record(int id, String title)
	{
		this.id=id;
		this.title = title;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
}
