package com.rohit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.beans.Student;
import com.rohit.resources.SpringConfig;

// Here, we used the Automatic wiring using @Autowired and NOT 
//In Config.java class === { stud.setAddress(AddObj());}
public class Main {

	public static void main(String[] args) {
		// String resource_file_path = "/com/rohit/resources/applicationContext.xml";

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Student std = context.getBean(Student.class);
		System.out.println("----------------");
		std.display();
	}
}
