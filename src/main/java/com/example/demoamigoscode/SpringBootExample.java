package com.example.demoamigoscode;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/users")
public class SpringBootExample {

	private final UserRepository userRepository;

	public SpringBootExample(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExample.class, args);
	}

	@GetMapping
	public List<User> getUsers() {
		// return List.of();
		return userRepository.findAll();
	}

	/**
	 * NewCustomerRequest
	 */
	public record NewUserRequest(String name, String email, Integer age) {

	}

	@PostMapping
	public void addUser(@RequestBody NewUserRequest request) {
		User user = new User();
		user.setAge(request.age());
		user.setName(request.name());
		user.setEmail(request.email());
		userRepository.save(user);
	}

	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable("userId") Integer id) {
		userRepository.deleteById(id);
	}

	public record UpdateUserRequest(String name, String email, Integer age) {

	}

	@PutMapping("{userId}")
	public void updateUser(@PathVariable("userId") Integer id, @RequestBody UpdateUserRequest request) {
		Optional<User> OptionalUser = userRepository.findById(id);
		User user = OptionalUser.get();
		if (request.age() != null) user.setAge(request.age());
		if (request.email() != null) user.setEmail(request.email());
		if (request.name() != null) user.setName(request.name());
		userRepository.save(user);
	}
}
