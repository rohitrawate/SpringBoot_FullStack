package com.rohit.rest.webservices.user;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;

	@ManyToOne(fetch = FetchType.LAZY )  // Along post the user will be fetched 
	@JsonIgnore      // For users to be not part of the Post bean
//	@JoinColumn

	private User user;
	
	public Integer getId() {
		return id;
	}

	@Size(min = 10)
	public String getDescription() {
		return description;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
 
	
}
