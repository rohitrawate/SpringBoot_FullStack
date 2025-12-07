package com.rohit.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rohit.beans.Student;

@Configuration
public class JavaBasedConfig {

	@Bean("studObj")
	public Student stdId1() {
		Student std = new Student();

		std.setName("Pradeep");
		std.setRollno(303);
		std.setEmail("pradeep@gmail.com");

		return std;
	}

	@Bean("studObj2")
	public Student stdId2() {
		Student std = new Student();

		std.setName("Pramod");
		std.setRollno(909);
		std.setEmail("pramod@gmail.com");

		return std;
	}

}
