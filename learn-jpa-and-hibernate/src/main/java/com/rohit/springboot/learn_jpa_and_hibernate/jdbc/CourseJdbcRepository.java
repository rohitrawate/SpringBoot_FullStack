package com.rohit.springboot.learn_jpa_and_hibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rohit.springboot.learn_jpa_and_hibernate.course.Course;


		/*    Spring JDBC 
		 * 
		 */
@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_Query =
			""" 
			 insert into course (id, name, author)
			 values(?, ?, ?);
			""";
	
	private static String DELETE_QUERY =
			"""
			 Delete from Course
			 where id = ?
			""";
	
	private static String SELECT_QUERY =
			"""
			 Select * from Course
			 where id = ?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_Query, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {  				// return Course Object
		// ResultSet -> Bean = Row Mappers =>  			id
		return springJdbcTemplate.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Course.class) ,id);
		
	}
	
}
