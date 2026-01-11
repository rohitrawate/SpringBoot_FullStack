package com.rohit.rest.webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.rest.webservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
