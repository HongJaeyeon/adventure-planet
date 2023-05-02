package com.ssafy.attraction.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.attraction.model.AttractionDto;

public interface AttractionService {

	List<AttractionDto> searchAttraction(Map<String, Object> map);

}
