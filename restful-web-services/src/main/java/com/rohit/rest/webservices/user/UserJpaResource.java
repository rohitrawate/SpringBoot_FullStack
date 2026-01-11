package com.rohit.rest.webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rohit.rest.webservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository repository;
	
	
//	private to public : For "Could not generate CGLIB subclass of UserResource class"
	public UserJpaResource(  UserRepository repository){
		System.out.println("User Resource");
		this.repository = repository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	// http://localhost:8080/users
	
	//Entity
	//WebMvcLinkBuilder
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id){
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");   // In small cases
		}
		
		EntityModel<User> entityModel =  EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createdUser( @Valid @RequestBody User user) {
		
		User savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
