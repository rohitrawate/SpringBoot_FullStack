package com.rohit.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value("Pramod")
	private String name;
	@Value("909")
	private int rollno;
	@Value("99.96f")
	private float marks;

	public String getNameString() {
		return name;
	}

	public void setNameString(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Rollno :" + rollno);
		System.out.println("Marks : " + marks);
	}

//	public void display() {
//		System.out.println("");
//	}

}
