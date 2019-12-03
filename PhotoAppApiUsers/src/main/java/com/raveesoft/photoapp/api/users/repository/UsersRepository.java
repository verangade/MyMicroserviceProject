package com.raveesoft.photoapp.api.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.raveesoft.photoapp.api.users.data.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);

}
