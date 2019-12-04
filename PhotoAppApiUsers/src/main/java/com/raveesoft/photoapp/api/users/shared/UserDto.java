package com.raveesoft.photoapp.api.users.shared;

import java.io.Serializable;
import java.util.List;

import com.raveesoft.photoapp.api.users.ui.model.AlbumResponseModel;

public class UserDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5061109191407554199L;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String emncryptedPassword;
	
	private List<AlbumResponseModel> albums;
		
	public List<AlbumResponseModel> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumResponseModel> albums) {
		this.albums = albums;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmncryptedPassword() {
		return emncryptedPassword;
	}
	public void setEmncryptedPassword(String emncryptedPassword) {
		this.emncryptedPassword = emncryptedPassword;
	}
	
	
	
	
}
