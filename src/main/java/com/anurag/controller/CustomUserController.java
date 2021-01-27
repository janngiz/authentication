
package com.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.entity.User;
import com.anurag.service.UserService;

@RestController
public class CustomUserController {

	@Autowired
	UserService userService;
	
	@PostMapping("save/all")
	public User saveUser(@RequestBody User user ) {
		 User saveUser = userService.saveUser(user);
		return saveUser;
	   
	}
}
