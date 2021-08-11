package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("jpa/users")
	public List<Employee> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	// Get specifcic user
	@GetMapping("jpa/users/{id}")
	public Employee getSpecificUser(@PathVariable int id) {
		return userRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	// Create a user
	@PostMapping("jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Employee user) { // The passed json in mapped to User
		Employee savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		// Status code CREATED(201), that's why used .created()
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteSpecificUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
