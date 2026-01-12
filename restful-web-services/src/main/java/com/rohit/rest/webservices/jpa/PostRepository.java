package com.rohit.rest.webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.rest.webservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
