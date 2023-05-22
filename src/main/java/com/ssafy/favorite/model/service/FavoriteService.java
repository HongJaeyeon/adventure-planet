package com.ssafy.favorite.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.attraction.model.AttractionDto;

public interface FavoriteService {

	void addFavorite(Map<String, Object> map);

	void deleteFavorite(Map<String, Object> map);

	List<AttractionDto> listFavorite(String userId);
	
}
