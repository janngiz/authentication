package com.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.models.AuthenticationRequest;
import com.anurag.models.AuthenticationResponse;
import com.anurag.service.MyUserDetailsService;
import com.anurag.util.Jwtutil;

@RestController
public class HomeResources {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	Jwtutil jwtTokenUtil;

	

	@GetMapping("/hi")
	public String hi() {
		return "hiworld";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "helloworld";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		// get userdetails from the username passed through the request by client

		
		//generate token
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		//store token in response object and Return
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
