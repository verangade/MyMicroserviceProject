package com.raveesoft.photoapp.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raveesoft.photoapp.api.users.ui.model.AlbumResponseModel;

@FeignClient(name="albums-ws",fallback=AlbumFallback.class)
public interface AlbumServiceClient {
	
	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);

}

@Component
class AlbumFallback implements AlbumServiceClient{

	@Override
	public List<AlbumResponseModel> getAlbums(String id) {
		
		return new ArrayList<AlbumResponseModel>();
	}
	
}
