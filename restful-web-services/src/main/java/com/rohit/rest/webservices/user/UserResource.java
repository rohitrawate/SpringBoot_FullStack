package com.rohit.rest.webservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;
	
//	private to public : For "Could not generate CGLIB subclass of UserResource class"
	public UserResource( UserDaoService service){
		System.out.println("User Resource");
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.finaAll();
	}
	// http://localhost:8080/users
	
	//Entity
	//WebMvcLinkBuilder
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id){
		User user = service.findOne(id);
		
		if(user== null) {
			throw new UserNotFoundException("id:"+id);
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");   // In small cases
		}
		
		EntityModel<User> entityModel =  EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		service.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createdUser( @Valid @RequestBody User user) {
		
		User savedUser = (User) service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
