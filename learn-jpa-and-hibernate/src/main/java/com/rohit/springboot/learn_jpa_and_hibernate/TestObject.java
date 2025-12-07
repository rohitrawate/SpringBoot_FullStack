package com.rohit.springboot.learn_jpa_and_hibernate;

import org.springframework.stereotype.Component;

@Component
public class TestObject {

	public TestObject() {
		System.out.println("TestObject : Bean Created");
	}
}
