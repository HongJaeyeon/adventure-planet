package com.ssafy.favorite.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;

@Mapper
public interface FavoriteMapper {

	int checkFavorite(Map<String, Object> map);

	void updateRevival(Map<String, Object> map);

	void addFavorite(Map<String, Object> map);

	void deleteFavorite(Map<String, Object> map);

	List<AttractionDto> listFavorite(String userId);

}
