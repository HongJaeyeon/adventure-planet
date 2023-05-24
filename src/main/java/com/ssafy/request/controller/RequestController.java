package com.ssafy.request.controller;

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
import com.ssafy.request.model.RequestDto;
import com.ssafy.request.model.service.RequestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"공유 요청 API"})
public class RequestController {
	private final Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	private RequestService requestService;
	
	public RequestController(RequestService requestService) {
		super();
		this.requestService = requestService;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "공유 요청 추가", notes = "여행 계획을 공유 요청합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "요청 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> addRequest(@RequestBody RequestDto requestDto) {
		logger.debug("from_user_id info : {}", requestDto.getFromUserId());
		logger.debug("plan_no info : {}", requestDto.getPlanNo());
		logger.debug("to_user_id info : {}", requestDto.getToUserId());
		try {
			requestService.addRequest(requestDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/list/{userId}")
	@ApiOperation(value = "공유 요청 리스트 조회", notes = "공유 요청 받은 여행 계획 리스트를 조회합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "요청 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> listRequest(@PathVariable String userId) {
		logger.debug("to_user_id info : {}", userId);
		try {
			List<RequestDto> list = requestService.listRequest(userId);
			return new ResponseEntity<List<RequestDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/delete/{requestNo}")
	@ApiOperation(value = "공유 요청 삭제", notes = "공유 요청을 거절합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "요청 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> deleteRequest(@PathVariable int requestNo) {
		logger.debug("requestNo info : {}", requestNo);
		try {
			requestService.deleteRequest(requestNo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
}
