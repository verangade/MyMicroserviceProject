package com.ravesoft.app.ws.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravesoft.app.ws.ui.model.response.User;

@RestController
@RequestMapping("users")
public class UserController {
	
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue="1") int page ,
			@RequestParam(value="limit", defaultValue="1") int limit, @RequestParam(value="limits",required=false) String limits) {
		return "Get user" +page+" "+limit+" "+limits;
	}
	
	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public User getUser(@PathVariable String userId) {
		User user = new User("1","Ra", "asas");
		
		return user;
	}
	
	@PostMapping
	public String createUSer() {
		return "create user";
	}
	
	@PutMapping
	public String updateUSer() {
		return "update user";
	}
	
	@DeleteMapping
	public String deleteUSer() {
		return "delete user";
	}
	

}
