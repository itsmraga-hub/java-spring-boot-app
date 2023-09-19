package com.example.demoamigoscode.controllers;

import com.example.demoamigoscode.SpringBootExample;
import com.example.demoamigoscode.UserRepository;
import com.example.demoamigoscode.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public record NewUserRequest(String name, String email, Integer age) {
    }

    @GetMapping()
    public List<User> getUsers() {
        // return List.of();
        return userRepository.findAll();
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
