package com.rohit.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rohit.beans.Address;
import com.rohit.beans.Student;

@Configuration
public class JavaConfig {

	@Bean("stud")
	public Student StudObj() {
		Student stud = new Student(1, "Rohit", AddObj());
		stud.setRollno(909);
		stud.setName("Rohit");
		stud.setAddress(AddObj());

		return stud;
	}

	@Bean("addr")
	public Address AddObj() {
		Address addr = new Address(323, "Pune", 21212);

		addr.setCity("Pune");
		addr.setHouseno(323);
		addr.setPincode(212121);

		return addr;
	}
}
