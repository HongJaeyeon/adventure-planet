package com.ssafy.attraction.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.GugunDto;

@Mapper
public interface AttractionMapper {

	List<AttractionDto> searchAttraction(Map<String, Object> map);

	List<GugunDto> searchGugun(int sidoCode);

	AttractionDto detailAttraction(int contentId);

}
