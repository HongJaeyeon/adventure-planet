package com.ssafy.share.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.share.model.ShareDto;
import com.ssafy.share.model.service.ShareService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/share")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"공유 API"})
public class ShareController {
	private final Logger logger = LoggerFactory.getLogger(ShareController.class);
	
	private ShareService shareService;
	
	public ShareController(ShareService shareService) {
		super();
		this.shareService = shareService;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "공유  추가", notes = "여행 계획을 공유합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "공유 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> addShare(@RequestBody ShareDto shareDto) {
		logger.debug("from_user_id info : {}", shareDto.getFromUserId());
		logger.debug("plan_no info : {}", shareDto.getPlanNo());
		logger.debug("to_user_id info : {}", shareDto.getToUserId());
		try {
			shareService.addShare(shareDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
}
