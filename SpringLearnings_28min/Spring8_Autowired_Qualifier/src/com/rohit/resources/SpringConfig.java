package com.rohit.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rohit.beans.Address;
import com.rohit.beans.Student;
import com.rohit.beans.Subjects;

@Configuration
public class SpringConfig {

	@Bean
	public Address AddObj() {
		Address addr = new Address();

		addr.setHouseno(999);
		addr.setCity("Delhi");
		addr.setPincode(123342);
		return addr;
	}

	@Bean
	public Subjects SubObj() {
		Subjects subj = new Subjects();

		List<String> subject_list = new ArrayList<String>();
		subject_list.add("Java");
		subject_list.add("Python");
		subject_list.add("C++");

		subj.setSubjects(subject_list);

		return subj;
	}

	@Bean
	public Student StudObj() {
		Student student = new Student();

		student.setName("Pramod");
		student.setRollno(101);
//		stud.setAddress(AddObj()); // manually DI but with @Autowired automatic DI
//		student.setSubjects(SubObj());
		return student;
	}
}
