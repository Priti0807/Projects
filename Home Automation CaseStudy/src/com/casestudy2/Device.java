package com.casestudy2;

import java.time.Duration;

import java.time.LocalTime;

//------Prathamesh Jamadar---------

public class Device implements Switchable 
{
	int id;
	String name;
	String status;
	LocalTime time;
	public Device() {
		// TODO Auto-generated constructor stub
	}
	public Device(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		status="off";
		time=LocalTime.now();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	public String toString() {
		
		return "ID:"+this.id+"\nDevice name: "+this.name;	
	}
	
	public void onDevice() {
		if(getStatus().equalsIgnoreCase("ON"))
		{
			System.out.println("Device already ON");
		}
		else
		{
			setStatus("ON");
			//status="ON";
			setTime(LocalTime.now());
		//	time=LocalTime.now();
			System.out.println(name+":"+"Is ON");
		}
		
		
	}
	
	public void offDevice() {
		if(getStatus().equalsIgnoreCase("OFF"))
		{
			System.out.println("Device already OFF");
		}
		else
		{
			setStatus("OFF");
			
			setTime(LocalTime.now());
		
			System.out.println(name+":"+"OFF");
		}
		
		
	}

	public void checkTime() {
		Duration d1 = Duration.between(this.time,LocalTime.now());  
	    System.out.println("\nUsage Time: "+d1.toMinutes() + d1.toSeconds()+"Seconds");
		
	}
	
	

}
