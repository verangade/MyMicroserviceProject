package com.ravesoft.app.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravesoft.app.ws.ui.model.request.UserDetailRequestModel;
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
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = new User("1","Ra", "asas");
		ResponseEntity<User> rs = new ResponseEntity<User>(user, HttpStatus.OK);
		return rs;
	}
	
	
	/*@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public User getUser(@PathVariable String userId) {
		User user = new User("1","Ra", "asas");
		
		return user;
	}*/
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE}	
			,produces={MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> createUSer(@Valid @RequestBody UserDetailRequestModel model) {
		
		User user = new User();
		user.setId(model.getId());
		user.setEmail(model.getEmail());
		user.setName(model.getName());
		user.setAddress(model.getAddress());
		
		ResponseEntity<User> rs = new ResponseEntity<User>(user, HttpStatus.OK);
		return rs;
	}
	
	@PutMapping
	public String updateUSer() {
		
		String x = null;
		//x.chars();
		
		throw new NullPointerException();
		//return "update user";
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUSer(@PathVariable String id) {
		return ResponseEntity.noContent().build();
	}
	

}
