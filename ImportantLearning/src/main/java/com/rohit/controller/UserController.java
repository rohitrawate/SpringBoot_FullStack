package com.rohit.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.model.User;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String home() {
		return "Home port 9090: IMPORTANT Learninigs"; 
	}
	
	@GetMapping("/user-details")
	public String getUserInfo() {
		User user = new User(101, "Rohit", "AI Engineer");
		return "User : id- " + user.getId() + " name- "+ user.getName()  +" role- "+ user.getEmail()  ;
	}
	
	@GetMapping("/get-user")
	public User getUser() {
		User user = new User(707, "Pramod", "Full Stack Developer");
		
		return user;    // Returns in the JSON Format
	}
	
	@PostMapping("/addUser")
	public String addUser( @RequestBody User user) {
		int id = user.getId();
		String name = user.getName();
		String role =  user.getEmail();
		
		System.out.println("User : "+ user.toString());
		return "id: "+id+ "\nname: "+name+ "\nrole: "+role ;
	}
}
