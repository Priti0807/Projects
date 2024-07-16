package com.casestudy2;

import java.time.Duration;
import java.time.LocalTime;
//------Yash Ambekar---------
public class AirConditioner extends Device implements Switchable {
	
	public AirConditioner() {
		
	}

	public AirConditioner(int id,String name) {
		super(id,name);
	}
	public void onDevice() {
		
		if(getStatus().equalsIgnoreCase("ON"))
		{
			System.out.println("Device already ON");
		}
		else
		{
			setStatus("ON");
	
			setTime(LocalTime.now());
	
			System.out.println(name+":"+"Is ON");
		}

	}

	
	public void offDevice() {
		setStatus("OFF");
		//status="ON";
		setTime(LocalTime.now());
	//	time=LocalTime.now();
		System.out.println(name+"OFF");
		
	}

	
	public void checkTime() {
	
	    Duration d1 = Duration.between(this.time,LocalTime.now());  
	    System.out.println("\nUsage Time: "+d1.toMinutes() + d1.toSeconds()+"Seconds");

	}
	

}
