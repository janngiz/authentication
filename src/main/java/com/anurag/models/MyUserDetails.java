package com.anurag.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.anurag.entity.User;

public class MyUserDetails implements UserDetails {

	private String username;
	
	  private String password;
	    private boolean active;
	    private List<GrantedAuthority> authorities;
	    
	    
	    //construcor to fetch data from the user object and check the authentication
	    
	    public MyUserDetails(User user) {
	        this.username = user.getUserName();
	        this.password = user.getPassword();
	        this.active = user.isActive();
	        this.authorities = Arrays.stream(user.getRoles().split(","))
	                    .map(SimpleGrantedAuthority::new)
	                    .collect(Collectors.toList());
	    }

	
	
	
	
	
	

	public MyUserDetails(String username) {

		this.username = username;
	}

	public MyUserDetails() {

		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return  password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

}
