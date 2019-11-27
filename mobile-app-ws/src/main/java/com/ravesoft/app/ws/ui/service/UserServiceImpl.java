package com.ravesoft.app.ws.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravesoft.app.ws.ui.model.request.UserDetailRequestModel;
import com.ravesoft.app.ws.ui.model.response.User;
import com.ravesoft.app.ws.ui.util.Util;

@Service
public class UserServiceImpl implements UserService {
	
	private Util util;
	
	public UserServiceImpl() {
		
	}
	
	
	@Autowired
	public UserServiceImpl(Util util) {
		super();
		this.util = util;
	}



	@Override
	public User createUSer(UserDetailRequestModel model) {
		User user = new User();
		user.setId(util.generateId());
		user.setEmail(model.getEmail());
		user.setName(model.getName());
		user.setAddress(model.getAddress());
		
		return user;
	}

}
