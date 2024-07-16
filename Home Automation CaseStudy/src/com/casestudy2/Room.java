package com.casestudy2;

import java.util.ArrayList;
import java.util.List;

//------------Priti Hakam---------------
public class Room {
	String roomType;
	List<Device> devArr;
	public Room() {
		devArr=new ArrayList<>();
	}
	public Room(String roomType) {
		super();
		this.roomType = roomType;
		devArr=new ArrayList<>();
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	@Override
	public String toString() {
		String s= "\nroomType:"+this.roomType;
		return s;
		
	}
	

}
