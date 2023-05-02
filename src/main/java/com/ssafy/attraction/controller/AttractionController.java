package com.ssafy.attraction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	private final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	@Autowired
	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> searchAttraction(@RequestBody Map<String, Object> map) {
		logger.debug("Map info : {}", map);
		List<AttractionDto> list = attractionService.searchAttraction(map);
		
		return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
		  
	}
}
