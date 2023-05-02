package com.ssafy.attraction.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {

	List<AttractionDto> searchAttraction(Map<String, Object> map);

}
