package com.anurag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entity.User;
import com.anurag.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	  public User saveUser(User user) {
		  User saveUser  = userRepo.save(user);
		  return saveUser;
	  }
}
