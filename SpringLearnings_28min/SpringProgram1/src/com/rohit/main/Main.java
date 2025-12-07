package com.rohit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rohit.beans.Student;

public class Main {

	public static void main(String[] args) {

		String config_loc = "com/rohit/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);

		Student std = (Student) context.getBean("stdId");
		std.display();
		Student std2 = (Student) context.getBean("stdId2");
		std2.display();

	}
}

// spring-beans-xxx.jar    // xxx - version
// spring-core-xxx.jar
//   context.jar  #logging.jar  #expression.jars