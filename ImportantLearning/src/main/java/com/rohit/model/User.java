package com.rohit.model;

public class User {

	private int id;
    private String name;
    private String role;
    
 // Constructor
    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters
    public int getId(){
    	return id; 
    }
    
    public String getName(){ 
    	return name; 
    }
    
    public String getRole(){
    	return role; 
    }
    
}
