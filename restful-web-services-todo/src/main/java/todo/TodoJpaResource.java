package todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.rest.webservices.restful_web_services_todo.repository.TodoRepository;

@RestController
public class TodoJpaResource {
	
	private TodoService todoService;
	private TodoRepository todoRepository;
	
	public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {

//		List<Todo> todosbyUsername = todoService.findByUsername(username);
//		return todosbyUsername;
		
		return todoRepository.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {

//		return todoService.findById(id);
		return todoRepository.findById(id).get();
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable String username, @PathVariable int id) {
//		  todoService.deleteById(id);
		 
//		 return ResponseEntity.noContent().build();
		todoRepository.deleteById(id);
		 return ResponseEntity.ok("Deleted");
	}

	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
//		  Todo todo_toupdate = todoService.findById(id);
//		  
//		  todo_toupdate.setDescription(todo.getDescription());
//		  todo_toupdate.setTargetDate(todo.getTargetDate());
//		  todo_toupdate.setDone(false);
		  
//		todoService.updateTodo(todo);
		todoRepository.save(todo);
//		 return ResponseEntity.noContent().build();
		 return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		String description = todo.getDescription();
//		LocalDate targetdate = todo.getTargetDate();
//		Boolean status = todo.isDone();
//		Todo created_todo = todoService.addTodo(username, description, targetdate, status);
		todo.setUsername(username);
		todo.setId(null);
		return todoRepository.save(todo);
//		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), 
//	              todo.getTargetDate(),todo.isDone() );
//	      
//	      return createdTodo;
//		return created_todo;
	}
}
