package com.rohit.springboot.learn_jpa_and_hibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
}
