package com.raveesoft.photoapp.api.albums.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumController {
	
	@GetMapping("status/check")
	public String statusCheck() {
		return "Photo album api is running";
	}

}
