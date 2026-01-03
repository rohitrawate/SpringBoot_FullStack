package com.rohitwebAppToDo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
 
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo((long) ++todosCount, "in28min", "Learn AWS", 
					LocalDate.now().plusMonths(2), false));
		todos.add(new Todo((long) ++todosCount, "in28min", "Learn DevOps", 
					LocalDate.now().plusWeeks(3), false));
		todos.add(new Todo((long) ++todosCount, "in28min", "Learn Full Stack Development 1", 
					LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todos -> todos.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
//		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		Todo todo = new Todo((long) ++todosCount, username, description, targetDate, done);
//		 Addding to current Todos
		todos.add(todo);
	}

	public void deleteById(long id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
