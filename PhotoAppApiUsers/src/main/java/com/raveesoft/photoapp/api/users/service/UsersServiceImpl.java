package com.raveesoft.photoapp.api.users.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raveesoft.photoapp.api.users.data.UserEntity;
import com.raveesoft.photoapp.api.users.repository.UsersRepository;
import com.raveesoft.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository usersRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());
		userDto.setEmncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity = mapper.map(userDto, UserEntity.class);

		usersRepository.save(entity);

		UserDto returnValue = mapper.map(entity, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = usersRepository.findByEmail(username);

		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(userEntity.getEmail(), userEntity.getEmncryptedPassword(), true, true, true, true,
				new ArrayList<>());

	}

	@Override
	public UserDto getUserDetailByEmail(String email) {
		UserEntity userEntity = usersRepository.findByEmail(email);

		if (userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
	
		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserDetailById(String userId) {
		UserEntity userEntity = usersRepository.findByUserId(userId);

		if (userEntity == null) {
			throw new UsernameNotFoundException(userId);
		}
	
		return new ModelMapper().map(userEntity, UserDto.class);
	}

}
