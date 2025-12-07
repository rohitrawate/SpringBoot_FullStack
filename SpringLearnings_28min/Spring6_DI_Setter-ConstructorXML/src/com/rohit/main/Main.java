package com.rohit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rohit.beans.Student;

public class Main {

	public static void main(String[] args) {

		String resource_file_path = "com/rohit/resources/applicationContext.xml";
		ApplicationContext cxt = new ClassPathXmlApplicationContext(resource_file_path);

		Student std = (Student) cxt.getBean("stud");
		System.out.println("----------------");
		std.dispay();
	}
}
