package com.shruti.Covid19Project.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	UserRepository userRepository;

// Retrieve all Countries
	@GetMapping("/country")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

// Get details of specific Country
	@GetMapping("/country/{id}")
	public Optional<User> retriveUser(@PathVariable int id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		return user;

	}

// Delete a Country	
	@DeleteMapping("/country/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

// Create a new Country
	@PostMapping("/country")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

// Update a Country
	@PutMapping("/country/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable int id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent())

			return ResponseEntity.notFound().build();

		user.setId(id);

		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}

}
