package com.chiku.dist.dmsrest.controller;


import com.chiku.dist.dmsrest.model.User;
import com.chiku.dist.dmsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/add")
	public void createUser(@RequestBody User user) {
		userService.addNewUser(user);
	}

	@GetMapping(path = "/get")
	public List<User> getUserList() {
		return userService.getUserList();
	}

	@GetMapping(path = "/get/{user_id}")
	public List<User> getUserList(@PathVariable("user_id") Long userId) {
		return userService.getUserById(userId);
	}
}
