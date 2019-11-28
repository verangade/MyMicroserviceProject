package com.raveesoft.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message="First name cannot be null")
	@Size(min=2,message="minimum 2 characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2,message="minimum 2 characters")
	private String lastName;
	
	@NotNull(message="Password cannot be null")
	@Size(min=4, max=8, message="minimum 4 characters max 8")
	private String password;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	
	public CreateUserRequestModel() {
	}
	
	public CreateUserRequestModel(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
