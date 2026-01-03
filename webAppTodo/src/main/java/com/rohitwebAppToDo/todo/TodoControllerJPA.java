package com.rohitwebAppToDo.todo;

import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private TodoService todoService;
	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		String username = getLoggedInUsername(model);
		
//		List<Todo> todos =  todoService.findByUsername(username);
		List<Todo> todos =  todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	//	GET, POST
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusMonths(1), false);
		model.put("todo", todo);
		return "todo";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
	
	
//	public String addNewTodoPage(@RequestParam String description, ModelMap model) {
		@RequestMapping(value="add-todo", method = RequestMethod.POST)
		public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "todo";
			}
			
			String username = getLoggedInUsername(model);
			todo.setUsername(username);
			todoRepository.save(todo);
			
//			todoService.addTodo(username, todo.getDescription(), 
//					todo.getTargetDate(), todo.isDone());
			return "redirect:list-todos";
		}
		
		//		DELETE
		@RequestMapping("delete-todo")
		public String deleteTodo(@RequestParam int id) {
			//Delete todo
			
//			todoService.deleteById(id);
			todoRepository.deleteById(id);
			return "redirect:list-todos";
			
		}
		
		@RequestMapping(value="update-todo", method = RequestMethod.GET)
		public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//			Todo todo = todoService.findById(id);
			Todo todo = todoRepository.findById(id).get();    // .findById() -> returns Optional ->.get()
			model.addAttribute("todo", todo);
			return "todo";
		}
		
		@RequestMapping(value="update-todo", method = RequestMethod.POST)
		public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "todo";
			}
			
			String username = getLoggedInUsername(model);
			todo.setUsername(username);
			todoRepository.save(todo);
//			todoService.updateTodo(todo);
			return "redirect:list-todos";
		}
	
	
	
}
