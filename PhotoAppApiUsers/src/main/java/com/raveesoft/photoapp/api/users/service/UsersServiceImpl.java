package com.raveesoft.photoapp.api.users.service;

import java.util.UUID;

import com.raveesoft.photoapp.api.users.shared.UserDto;

public class UsersServiceImpl implements UsersService {

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
