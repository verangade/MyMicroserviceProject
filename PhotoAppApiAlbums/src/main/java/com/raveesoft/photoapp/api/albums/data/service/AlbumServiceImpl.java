package com.raveesoft.photoapp.api.albums.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raveesoft.photoapp.api.albums.data.AlbumEntity;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Override
	public List<AlbumEntity> getAlbums(String userId) {
		
		List<AlbumEntity> list = new ArrayList<AlbumEntity>();
		AlbumEntity albumEntity1 = new AlbumEntity();
		albumEntity1.setId((long)1);
		albumEntity1.setAlbumId("E1234");
		albumEntity1.setUserId(userId);
		albumEntity1.setName("Punk");
		albumEntity1.setDescription("New Punk album");
		
		AlbumEntity albumEntity2 = new AlbumEntity();
		albumEntity2.setId((long)2);
		albumEntity2.setAlbumId("X564");
		albumEntity2.setUserId(userId);
		albumEntity2.setName("Pop");
		albumEntity2.setDescription("New Pop album");
		
		list.add(albumEntity1);
		list.add(albumEntity2);
		return list;
	}

}
