package com.ravesoft.app.ws.ui.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public String generateId() {
		return UUID.randomUUID().toString();
	}

}
