package com.rohit.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
//  JPA/ Hibernate >  Database
//	UserDaoService > Static List
	
	public UserDaoService() {
		System.out.println("UserDao-Service construct");
	}
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	static {
		users.add(new User(++usersCount, "Rohit", LocalDate.now().plusDays(18).minusYears(25)));
		users.add(new User(++usersCount, "Pramod", LocalDate.now().minusYears(29)));
		users.add(new User(++usersCount, "Pradeep", LocalDate.now().minusYears(31)));
	}
	public List <User> finaAll(){
		return users;
	}
	
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
		
	}
	
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
//		   .findFirst()  returns Optional type
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
//		return users.stream().filter(predicate).findFirst().orElse(null);
//		   .findFirst()  returns Optional type
	}
	
}
