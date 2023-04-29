package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService usrService;

	@PostMapping("/login")
	public String validateUser(@RequestBody User u) {
		System.out.println(u.getUsername());
		return usrService.validateUser(u.getUsername(), u.getPassword());
	}

	@PostMapping("/signup")
	public User addUser(@RequestBody User u) {
		return usrService.saveUser(u);
	}
}
