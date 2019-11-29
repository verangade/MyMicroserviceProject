package com.raveesoft.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raveesoft.photoapp.api.users.data.UserEntity;
import com.raveesoft.photoapp.api.users.repository.UsersRepository;
import com.raveesoft.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	
	private UsersRepository usersRepository;
	
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}


	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity = mapper.map(userDto, UserEntity.class);
		entity.setEmncryptedPassword("test");
		usersRepository.save(entity);
		
		UserDto returnValue = mapper.map(entity, UserDto.class); 
		return returnValue;
	}

}
