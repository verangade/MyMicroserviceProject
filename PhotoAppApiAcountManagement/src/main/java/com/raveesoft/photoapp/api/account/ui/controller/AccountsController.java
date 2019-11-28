package com.raveesoft.photoapp.api.account.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@GetMapping("/status/check")
	public String status() {
		return "account microservice is working";
	}

}
