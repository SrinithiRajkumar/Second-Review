package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Students {
	
	@Id
	private String roll_no;
	
	private String name;
	private String dept;
	private int year;
	private long contact_no;
	private String city;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Students(String roll_no, String name, String dept, int year, long contact_no, String city) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.dept = dept;
		this.year = year;
		this.contact_no = contact_no;
		this.city = city;
	}
	
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}