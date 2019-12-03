package com.raveesoft.photoapp.api.albums.data.service;

import java.util.List;

import com.raveesoft.photoapp.api.albums.data.AlbumEntity;

public interface AlbumService {
	
	public List<AlbumEntity> getAlbums(String userId);

}
