package com.ravesoft.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	
	
	@GetMapping
	public String getUSer() {
		return "Get user";
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
