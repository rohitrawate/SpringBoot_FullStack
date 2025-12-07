package com.rohit.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) { };

record Address(String country, String city) { };

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Rohit";
	}
	
	@Bean
	public int age() {
		return 25;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Pramod", 20, new Address("Main Street", "Delhi"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		return  new Person(name(), age(), address()); //name , age , address() Method Call
		 
	}
	
	@Bean
	@Primary
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name, age, address3 ); //name , age , address3
	}
	
	@Bean
	public Person person4Parameters(String name, int age, @Qualifier("address3Qualifier") Address address) {
		return new Person(name, age, address ); //name , age , address
		 
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("India", "Bombay");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address("Shrinagar", "J&K");
	}
}
