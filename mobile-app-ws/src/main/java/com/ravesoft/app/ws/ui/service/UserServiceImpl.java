package com.ravesoft.app.ws.ui.service;

import org.springframework.stereotype.Service;

import com.ravesoft.app.ws.ui.model.request.UserDetailRequestModel;
import com.ravesoft.app.ws.ui.model.response.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User createUSer(UserDetailRequestModel model) {
		User user = new User();
		user.setId(model.getId());
		user.setEmail(model.getEmail());
		user.setName(model.getName());
		user.setAddress(model.getAddress());
		
		return user;
	}

}
