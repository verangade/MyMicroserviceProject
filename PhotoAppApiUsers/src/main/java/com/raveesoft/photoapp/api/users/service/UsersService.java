package com.raveesoft.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.raveesoft.photoapp.api.users.shared.UserDto;

public  interface UsersService extends UserDetailsService{
	
	public UserDto createUser(UserDto userDto);
	public UserDto getUserDetailByEmail(String email);

}
