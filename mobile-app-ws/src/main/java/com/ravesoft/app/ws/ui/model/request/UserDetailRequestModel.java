package com.ravesoft.app.ws.ui.model.request;

public class UserDetailRequestModel {
	private String id;
	private String name;
	private String email;
	private String address;
	private Integer age;
	
	public UserDetailRequestModel() {
	}
	
	public UserDetailRequestModel(String id, String name, String email, String address, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
