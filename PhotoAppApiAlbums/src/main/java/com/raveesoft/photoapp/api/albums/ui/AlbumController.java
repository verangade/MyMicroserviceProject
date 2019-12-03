package com.raveesoft.photoapp.api.albums.ui;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raveesoft.photoapp.api.albums.data.AlbumEntity;
import com.raveesoft.photoapp.api.albums.data.service.AlbumService;
import com.raveesoft.photoapp.api.albums.ui.model.AlbumResponseModel;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("status/check")
	public String statusCheck() {
		return "Photo album api is running";
	}
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<AlbumResponseModel> userAlbums(@PathVariable String id){
		List<AlbumResponseModel> returnValue = new ArrayList<AlbumResponseModel>();
		
		List<AlbumEntity> list = albumService.getAlbums(id);
		
		if(list==null || list.isEmpty()) {
			return returnValue;
		}
		
		Type listType = new TypeToken<List<AlbumResponseModel>>(){}.getType();
		returnValue = new ModelMapper().map(list, listType);
		
		return returnValue;
	}

}
