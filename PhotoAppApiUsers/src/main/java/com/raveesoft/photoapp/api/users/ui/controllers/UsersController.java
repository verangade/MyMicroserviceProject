package com.raveesoft.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.apache.commons.lang.ObjectUtils.Null;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raveesoft.photoapp.api.users.service.UsersService;
import com.raveesoft.photoapp.api.users.shared.UserDto;
import com.raveesoft.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.raveesoft.photoapp.api.users.ui.model.CreateUserResponseModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String status() {
		return "Users microservice is working port : "+env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userDetails, UserDto.class);
		usersService.createUser(userDto);
		
		CreateUserResponseModel response = mapper.map(userDto, CreateUserResponseModel.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}

}
