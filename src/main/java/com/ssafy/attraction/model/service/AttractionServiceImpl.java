package com.ssafy.attraction.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService{

	@Autowired
	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<AttractionDto> searchAttraction(Map<String, Object> map) {
		return attractionMapper.searchAttraction(map);
	}

}
