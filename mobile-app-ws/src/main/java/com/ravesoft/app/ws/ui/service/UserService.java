package com.ravesoft.app.ws.ui.service;

import com.ravesoft.app.ws.ui.model.request.UserDetailRequestModel;
import com.ravesoft.app.ws.ui.model.response.User;

public interface UserService {
	public User createUSer(UserDetailRequestModel user); 
}
