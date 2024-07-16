//Priti Hakam
//Yash Ambekar
//Prathamesh Jamadar

package com.casestudy2;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MainApp {
	static House house=new House();
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		int count=0;
		Scanner sc = new Scanner(System.in);
		
		while(count!=2)
		{
		try
		{
			System.out.println("Enter House no:");
			int no=sc.nextInt();
			System.out.println("Enter Owner Name");
			String name=sc.next();
			house.setNo(no);
			house.setOwner_name(name);
			operations();
			
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input. Please enter the correct data.");
			count++;
            sc.nextLine();
		}
		
		}
	}
	
    //--------------Yash Ambekar-------------
	
	public static void operations() 
	{
		
	int choice = -1;
		
	do
	{
		try
		{
		System.out.println("|------------------------------|");
		System.out.println("|   Home Automation System     |");
		System.out.println("|------------------------------|");
		System.out.println("|       1. Add Room            |");
		System.out.println("|       2.Add device           |");
		System.out.println("|       3.Access Device        |");
		System.out.println("|       4.Display              |");	
		System.out.println("|       0.Exit                 |");
		System.out.println("|------------------------------|");
		System.out.println("Enter your choice: "); 
		
		choice=sc.nextInt();
				
		switch(choice)
		{
			case 1:
			{
				addRoom();
				break;
			}
			case 2:
			{
				addDevice();
				break;
			}
			case 3:
			{
				accessDevice();
				break;
			}
			case 4:
			{
				display();
				break;
				
			}
		}	
	}
		catch(Exception e)
		{
			System.out.println("Invalid input.Kindly Enter a number from list");
			
			sc.nextLine();
		}
		
	}
	while(choice!=0);
		
	}
	
	//--------------Yash Ambekar-------------
	public static void display() 
	{
		   System.out.println("House No: " + house.getNo());
	       System.out.println("Owner: " + house.getOwner_name());
	        for (Room room : house.roomArr)
	        {
	            System.out.println("Room: " + room.getRoomType());
	            for (Device device : room.devArr)
	            {
	                System.out.println("Device information:- " + device);
	            }
	        }
		
	}
//------------Priti Hakam + Exceptions Handle by Prathamesh Jamadar + Yash Ambekar-------------------
	public static void accessDevice() 
	{
		try
		{
		System.out.println("Select  room type");
		
		Iterator<Room> itr=house.roomArr.iterator();
		int i=0;
		while(itr.hasNext())
		{
			System.out.println(itr.next().getRoomType() +"press"+ ++i);
		}
		int roomChoice=sc.nextInt();
		roomChoice--;
		sc.nextLine();
		
		Room choice=house.roomArr.get(roomChoice);
		System.out.println("selct Devices \n");
		Iterator<Device> itr1=choice.devArr.iterator();
		
		int j=0;
		while(itr1.hasNext())
		{
			System.out.println(itr1.next().getName()+"Press"+ ++j);
		}
		int devChoice=sc.nextInt();
		devChoice--;
		sc.nextLine();
		Device devCh=choice.devArr.get(devChoice);
		System.out.println("\n Accessing the device: "+devCh);
		
		int choice1;
		do
		{
			 System.out.println("+-----------------------------------+");
             System.out.println("|    Home Automation System         |");
             System.out.println("+-----------------------------------+");
             System.out.println("| 1 |       Turn On                 |");
             System.out.println("| 2 |       Turn Off                |");
             System.out.println("| 3 |       Check Status            |");
             System.out.println("| 4 |       Check Usage Time        |");
             System.out.println("| 0 |       Exit                    |");
             System.out.println("+-----------------------------------+");
			//System.out.println("\n1.Turn On\n2.Turn OFF\n3.Check Status \n4.Check Usage Time \n0.Exit \nEnter Choice:");
			choice1=sc.nextInt();
			switch(choice1)
			
			{
			case 1:
			{
				devCh.onDevice();
				break;
			}
			case 2:
			{
				devCh.offDevice();
				break;
			}
			case 3:
			{
				System.out.println(devCh.getStatus());
				
				break;
			}
			case 4:
			{
				devCh.checkTime();
				break;
			}
			}
		}
		while(choice1!=0);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Invalid selection");
		}
	}
		
//-------------------------Prathamesh Jamadar + Priti Hakam (Exceptions Handle by priti hakam)------------
	public static void addDevice() 
	{
		try
		{
		System.out.println("Select  room type");
		
		Iterator<Room> itr=house.roomArr.iterator();
		int i=0;
		while(itr.hasNext())
		{
			System.out.println(itr.next().getRoomType() +" press: "+ ++i);
		}
		int roomChoice=sc.nextInt();
		roomChoice--;
		sc.nextLine();
		
		if (roomChoice < 0 || roomChoice >= house.roomArr.size())
		{
            System.out.println("Invalid room choice.");
            return;
        }
		System.out.println("Enter Device Type:\n1.AirConditioner\n2.TV\n3.Light\n");
		String deviceType=sc.nextLine();
		
		if(deviceType.equalsIgnoreCase("AirConditioner"))
		{
			house.roomArr.get(roomChoice).devArr.add(new AirConditioner(1,"AC1"));
			System.out.println("Device added successfulyy");
		}
		else if(deviceType.equalsIgnoreCase("TV"))
		{
			house.roomArr.get(roomChoice).devArr.add(new TV(1,"TV1"));
			System.out.println("Device Added Successfulyy..");
		}
		else if(deviceType.equalsIgnoreCase("Light"))
		{
			house.roomArr.get(roomChoice).devArr.add(new Light(1,"Light1"));
			System.out.println("Device Added Successfully...");
		}
		else
		{
			System.out.println("Invalid Device type");
		}
	}
	catch(InputMismatchException e)
		{
			System.out.println("Enter correct input..");
			sc.nextLine();
		}
	catch(IndexOutOfBoundsException e)
		{
			System.out.println("Invalid Room choice");
		}
	}
	//-------------------------Prathamesh Jamadar -------------------
	public static void addRoom() {	
		try {
		System.out.println("Enter room type");
			String roomType=sc.next();
			
			house.roomArr.add(new Room(roomType));
			System.out.println("Room added SuccessFully");	
		}
		catch(Exception e)
		{
            System.out.println("Please Enetr Valid Information!");
		}
	}

}
