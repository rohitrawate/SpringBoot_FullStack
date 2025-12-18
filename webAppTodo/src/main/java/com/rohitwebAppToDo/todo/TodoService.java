package com.rohitwebAppToDo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1, "28min", "Learn AWS", 
					LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(2, "28min", "Learn DevOps", 
					LocalDate.now().plusWeeks(3), false));
		todos.add(new Todo(3, "28min", "Learn Full Stack Development", 
					LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
}
