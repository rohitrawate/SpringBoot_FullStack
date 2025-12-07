package com.rohit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

//	@Value("Pramod")
	private String name;
//	@Value("909")
	private int rollno;
//	@Value("99.96f")
//	private float marks;

	@Autowired
	private Address address;
	@Autowired
	private Subjects subjects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Rollno :" + rollno);
		System.out.println("Address : " + address);
		System.out.println("Subjects : " + subjects);
	}

//	public Subjects getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(Subjects subjects) {
//		this.subjects = subjects;
//	}

}
