package com.rohit.learn_spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
//		1. Launch a Spring Context
		 var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		 System.out.println("--- Spring Framework  ---");
//		2. Configure the things that we want Spring to manage - 
//		 HelloWorld - @Configuration
		 
		 System.out.println("context.bean : " + context.getBean("name"));
		 System.out.println("context.bean : " + context.getBean("age"));  
		 System.out.println("Person bean : "  +  context.getBean("person"));
		 System.out.println("Person bean : "  +  context.getBean("person2MethodCall"));
		 System.out.println("Person Param bean : "  +  context.getBean("person3Parameters"));
		 System.out.println("Person 4 bean : "  +  context.getBean("person4Parameters"));
		 System.out.println("Adress bean : "  +  context.getBean("address2"));
//		 System.out.println("Adress bean : "  +  context.getBean(Person.class));  // type of bean: class
		 System.out.println("Adress bean : "  +  context.getBean(Address.class));  // type of bean: class
		 
		 System.out.println("---- Bean Definitions ----");
		 Arrays.stream(context.getBeanDefinitionNames())
		       .forEach(System.out::println);
		 
		 
//		 Person p = (Person) context.getBean("person");
//		 System.out.println("p : "+ p);        // record implemented toString()
		 
	}
}
