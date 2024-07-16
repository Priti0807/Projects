package com.casestudy2;

import java.util.ArrayList;
import java.util.List;

public class House  //--------------Priti Hakam-------------
{
	int no;
	String owner_name;
	List<Room> roomArr;
	
	public House() {
		roomArr=new ArrayList<>();
	}

	public House(int no, String owner_name, List<Room> roomArr) {
		super();
		this.no = no;
		this.owner_name = owner_name;
		roomArr=new ArrayList<>();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
	
	
	

}
