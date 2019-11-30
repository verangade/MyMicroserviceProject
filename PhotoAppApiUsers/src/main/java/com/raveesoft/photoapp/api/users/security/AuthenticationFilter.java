package com.raveesoft.photoapp.api.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raveesoft.photoapp.api.users.service.UsersService;
import com.raveesoft.photoapp.api.users.shared.UserDto;
import com.raveesoft.photoapp.api.users.ui.model.LoginUserRequstModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private UsersService userService;
	private Environment env;
	
	public AuthenticationFilter(UsersService userService, Environment env,
			AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.env = env;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
		
			LoginUserRequstModel credentials = new ObjectMapper().
					readValue(request.getInputStream(), LoginUserRequstModel.class);
			return getAuthenticationManager().
					authenticate(new UsernamePasswordAuthenticationToken(
							credentials.getEmail(),
							credentials.getPassword(),
							new ArrayList<>()
							));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String userName =		((User)authResult.getPrincipal()).getUsername();
		UserDto userDto = userService.getUserDetailByEmail(userName);
		//after grab user details need to create jwt token
		
		String token = Jwts.builder().setSubject(userDto.getUserId())
				.setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(env.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512,env.getProperty("token.secret"))
				.compact();
		
		//set token to response
		response.setHeader("token", token);
		response.setHeader("userId", userDto.getUserId());
		
		
	}
	
	

}
