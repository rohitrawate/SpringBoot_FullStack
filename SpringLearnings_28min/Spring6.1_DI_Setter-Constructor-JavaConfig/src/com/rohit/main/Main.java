package com.rohit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.beans.Student;
import com.rohit.resources.JavaConfig;

public class Main {

	public static void main(String[] args) {

//		String resource_file_path = "com/rohit/resources/applicationContext.xml";
		ApplicationContext cxt = new AnnotationConfigApplicationContext(JavaConfig.class);

		Student std = (Student) cxt.getBean("stud");
		System.out.println("----------------");
		std.dispay();
	}
}
