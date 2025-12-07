package com.rohit.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	List<Course>  findByAuthor(String author);
}
