package com.ssafy.attraction.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.GugunDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;
import com.ssafy.favorite.model.mapper.FavoriteMapper;

@Service
public class AttractionServiceImpl implements AttractionService{

	@Autowired
	private AttractionMapper attractionMapper;
	
	@Autowired
	private FavoriteMapper favoriteMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper, FavoriteMapper favoriteMapper) {
		super();
		this.attractionMapper = attractionMapper;
		this.favoriteMapper = favoriteMapper;
	}

	@Override
	public List<AttractionDto> searchAttraction(Map<String, Object> map) {
		return attractionMapper.searchAttraction(map);
	}

	@Override
	public List<GugunDto> searchGugun(int sidoCode) {
		return attractionMapper.searchGugun(sidoCode);
	}

	@Override
	public AttractionDto detailAttraction(int contentId) {
		return attractionMapper.detailAttraction(contentId);
	}

	@Override
	public int checkFavorite(Map<String, Object> m) {
		return favoriteMapper.checkFavorite(m);
	}

}
