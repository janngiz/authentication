package com.anurag.models;

public class AuthenticationResponse {
	
	
	//json token, no change
	//no setter as, it is final variable, its value is set once object is created, thats it
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticationResponse(String jwt) {
		
		this.jwt = jwt;
	}
	
	

}
