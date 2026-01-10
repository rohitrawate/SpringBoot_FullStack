package com.rohit.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFilter("dynamicFilter")  // Enables runtime filtering
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private int id;
    private String name;
    private String email;
    
    public User() { }
 // Constructor
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId(){
    	return id; 
    }
    
    public String getName(){ 
    	return name; 
    }
    
    public String getEmail(){
    	return email; 
    }
    
}
