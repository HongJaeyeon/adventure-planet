package com.ssafy.favorite.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.favorite.model.FavoriteDto;
import com.ssafy.favorite.model.service.FavoriteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"찜 API"})
public class FavoriteController {
	private final Logger logger = LoggerFactory.getLogger(FavoriteController.class);
	
	private FavoriteService favoriteService;
	
	public FavoriteController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "찜 추가", notes = "관광지를 찜합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "찜 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> addFavorite(@RequestBody FavoriteDto favoriteDto) {
		logger.debug("userId info : {}", favoriteDto.getUserId());
		logger.debug("contentId info : {}", favoriteDto.getContentId());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("userId", favoriteDto.getUserId());
			map.put("contentId", favoriteDto.getContentId());
			favoriteService.addFavorite(map);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/delete")
	@ApiOperation(value = "찜 삭제", notes = "관광지 찜을 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "찜 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> deleteFavorite(@RequestParam String userId, @RequestParam int contentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("userId", userId);
			map.put("contentId", contentId);
			favoriteService.deleteFavorite(map);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/list/{userId}")
	@ApiOperation(value = "찜 조회", notes = "관광지 찜을 조회합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "찜 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> listFavorite(@PathVariable String userId) {
		try {
			List<AttractionDto> list = favoriteService.listFavorite(userId);
			
			for (AttractionDto attractionDto : list) {
				attractionDto.setIsFavorite(true);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
