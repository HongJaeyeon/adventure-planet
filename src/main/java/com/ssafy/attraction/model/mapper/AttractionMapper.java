package com.ssafy.attraction.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.attraction.model.AttractionDto;

public interface AttractionMapper {

	List<AttractionDto> searchAttraction(Map<String, Object> map);

}
