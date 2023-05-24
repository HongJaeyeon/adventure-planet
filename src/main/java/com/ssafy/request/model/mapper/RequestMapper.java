package com.ssafy.request.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.request.model.RequestDto;

@Mapper
public interface RequestMapper {

	void addRequest(RequestDto requestDto);

}
