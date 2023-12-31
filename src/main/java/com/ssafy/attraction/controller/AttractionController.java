package com.ssafy.attraction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.GugunDto;
import com.ssafy.attraction.model.service.AttractionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/attraction")
@Api(tags = {"여행지 API"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttractionController {
	private final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	@Autowired
	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@GetMapping("/search")
	@ApiOperation(value = "여행지 검색", notes = "여행지를 검색합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행지 검색 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> searchAttraction(@RequestParam(required = false, defaultValue = "-1") int sidoCode, @RequestParam(required = false, defaultValue = "-1") int gugunCode, @RequestParam(required = false, defaultValue = "-1") int contentTypeId, @RequestParam(required = false) String word, @RequestParam(required = false) String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(gugunCode);
		map.put("sidoCode", sidoCode);
		map.put("gugunCode", gugunCode);
		map.put("contentTypeId", contentTypeId);
		map.put("word", word);
		try {
			logger.debug("Map info : {}", map);
			List<AttractionDto> list = attractionService.searchAttraction(map);
			
			if (userId != null && list != null) {
				
				for (AttractionDto attractionDto : list) {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("userId", userId);
					m.put("contentId", attractionDto.getContentId());
					if (attractionService.checkFavorite(m) == 1) {
//						System.out.println("true");
						attractionDto.setIsFavorite(true);
					} else {
//						System.out.println("false");
						attractionDto.setIsFavorite(false);						
					}
				}
			}
			
			return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/detail/{contentId}")
	@ApiOperation(value = "여행지 세부 정보", notes = "여행지 세부 정보를 반환합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행지 세부 정보 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> detailAttraction(@PathVariable int contentId) {
		
		try {
			logger.debug("contentId : {}", contentId);
			AttractionDto attractionDto = attractionService.detailAttraction(contentId);
			
			return new ResponseEntity<AttractionDto>(attractionDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/getgugun/{sidoCode}")
	@ApiOperation(value = "구군코드 검색", notes = "구군코드를 검색합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행지 검색 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> searchGugun(@PathVariable int sidoCode) {
		
		try {
			List<GugunDto> list = attractionService.searchGugun(sidoCode);
			
			return new ResponseEntity<List<GugunDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
}
