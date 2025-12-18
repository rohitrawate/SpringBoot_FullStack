package com.rohitwebAppToDo.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password) {
		System.out.println("Authentication called");
		boolean isValidUserName = username.equalsIgnoreCase("rohitrawate");
		 boolean isValidPassword = password.equals("Qwerty@123");  // FIXED
	        
	        return isValidUserName && isValidPassword;
	}
}
