package com.casestudy2;

import java.time.Duration;
import java.time.LocalTime;
//------Prathamesh Jamadar---------
public class Light extends Device implements Switchable {
	public Light(){
		
	}

	public Light(int id,String name) {
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
