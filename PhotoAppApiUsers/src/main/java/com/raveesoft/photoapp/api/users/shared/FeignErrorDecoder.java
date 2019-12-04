package com.raveesoft.photoapp.api.users.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	/**
	 * methodKey means Feign client class name and method name 
	 * 
	 * here we can provide custome excption
	 * 
	 * this way no need to handle exception so this place is a centralized point to handle errors
	 */
	@Autowired
	Environment env ;
	@Override
	public Exception decode(String methodKey, Response response) {
		
		switch(response.status()) {
		case 400:
			break;
		case 404:{
			
			if(methodKey.contains("getAlbums")) {
			
				return new ResponseStatusException(HttpStatus.valueOf(response.status()),env.getProperty("album.exception.alboum_not_foud"));
			}
			break;
		}
		default:
			return new Exception();
		
		}
		
		return null;
	}

}
