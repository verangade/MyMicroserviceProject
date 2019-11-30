package com.raveesoft.photoapp.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private Environment env;
		
	@Autowired
	public WebSecurity(Environment env) {		
		this.env = env;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();		
		http.headers().frameOptions().disable();
		
		//this one is very important
		//our web services should be stateless
		/**
		 * when client application starts communicating with server side service it will 
			create a http session in client side
			this session will uniquly identify client when client communicates with server
			but these session will cahche information
			if you have multiple client application communication with the api multiple different http session will be created
			these session & cookies will be cached some information about the requests
			So our jwt token in authorization headers will also be cached
			Even if not provide athorization header in the requts , requets will be still authorized 
			We do not need that to happend. So will use SessionCreationPolicy.STATELESS so spring will never create session
			so that makes our http requests stateless . STATELESS is the most strict policy
			so most http headers needed to be reauthorize.
			some requests no need to have authorization header eg. sign up
			
			
			
		
		*/
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
	}
	
	

}
