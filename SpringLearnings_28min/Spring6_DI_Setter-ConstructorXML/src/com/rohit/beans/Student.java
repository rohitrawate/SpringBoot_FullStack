package com.rohit.beans;

public class Student {

	private int rollno;
	private String name;
	private Address address;

	public Student() {
		System.out.println("Student Obj created : Default Constructor");
	}

	public Student(int rollno, String name, Address address) {
		System.out.println("Student Obj created : Para Constructor");
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		System.out.println("setRollno : " + rollno);
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName: " + name);
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setAddress : " + address);
		this.address = address;
	}

	public void dispay() {
		System.out.println("Roll no: " + rollno);
		System.out.println("Name   : " + name);
		System.out.println("Address: " + address);
	}

}
