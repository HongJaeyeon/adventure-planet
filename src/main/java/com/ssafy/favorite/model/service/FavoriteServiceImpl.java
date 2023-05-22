package com.ssafy.favorite.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.favorite.model.mapper.FavoriteMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	private FavoriteMapper favoriteMapper;

	public FavoriteServiceImpl(FavoriteMapper favoriteMapper) {
		super();
		this.favoriteMapper = favoriteMapper;
	}

	@Override
	public void addFavorite(Map<String, Object> map) {	
		if (favoriteMapper.checkFavorite(map) == 1) {
			favoriteMapper.updateRevival(map);
		} else {
			favoriteMapper.addFavorite(map);
		}
	}

	@Override
	public void deleteFavorite(Map<String, Object> map) {
		favoriteMapper.deleteFavorite(map);
	}

	@Override
	public List<AttractionDto> listFavorite(String userId) {
		return favoriteMapper.listFavorite(userId);
	}
	
	
}
