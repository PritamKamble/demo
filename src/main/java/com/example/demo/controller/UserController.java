package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	User user(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	User createUser(@RequestBody User user) {
		user.toString();
		return userService.createUser(user);
	}

	@PutMapping
	User updateUser(@RequestBody User user) throws ResourceNotFoundException {
		return userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	Map<?, ?> deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
		return userService.deleteUserById(id);
	}

}
