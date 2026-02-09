package com.rohit.rest.webservices.restful_web_services_todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUsername(String username);



}
