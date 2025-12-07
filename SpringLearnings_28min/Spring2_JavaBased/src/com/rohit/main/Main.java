package com.rohit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.beans.Student;
import com.rohit.resources.JavaBasedConfig;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		
		ApplicationContext
		Student std1 = (Student) context.getBean("studObj");
		std1.display();

		System.out.println("-------------------");

		Student std = (Student) context.getBean("studObj2");
		System.out.println("-------Display---------");
		std.display();

	}
}
