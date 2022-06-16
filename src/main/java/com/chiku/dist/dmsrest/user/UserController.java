package com.chiku.dist.dmsrest.user;


import com.chiku.dist.dmsrest.document.Document;
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
	public void createDocument(@RequestBody User user) {
		userService.addNewUser(user);
	}

	@GetMapping(path = "/get")
	public List<User> getDocumentList() {
		return userService.getUserList();
	}

	@GetMapping(path = "/get/{user_id}")
	public List<User> getDocumentList(@PathVariable("user_id") Long userId) {
		return userService.getUserById(userId);
	}
}
