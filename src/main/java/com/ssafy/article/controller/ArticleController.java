package com.ssafy.article.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.service.ArticleService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"게시글 API"})
public class ArticleController {
	private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	@PostMapping("/image")
	public ResponseEntity<?> updateImage(@RequestParam("file") MultipartFile multipartFile) throws IOException  {
		return null;
//		return articleService.uploadImage(multipartFile);
	}
	
	@PostMapping(value = "/write", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ApiOperation(value = "게시글 등록", notes = "게시글을 등록합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 등록 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	//자원 요청의 body에 담아 오기에 @RequestBody
	public ResponseEntity<?> write(@RequestPart ArticleDto articleDto, @RequestPart("images") List<MultipartFile> multipartFiles) {
		logger.debug("articleDto info : {}", articleDto);
		try {
			articleService.write(articleDto);
//			System.out.println(articleDto.getArticleNo());
			for (MultipartFile multipartFile : multipartFiles) {				
				System.out.println(articleService.uploadImage(multipartFile, articleDto.getArticleNo()));
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/modify")
	@ApiOperation(value = "게시글 수정", notes = "게시글을 수정합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 수정 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> modify(@RequestBody ArticleDto articleDto) {
		logger.debug("articleDto info : {}", articleDto);
		try {
			articleService.modify(articleDto);
			return new ResponseEntity<List<ArticleDto>>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	
//	@DeleteMapping("delete/{articleNo}")
//	public ResponseEntity<?> delete(@RequestParam int articleNo) {
//		logger.debug("articleNo info : {}", articleNo);
//		try {
//			articleService.delete(articleNo);
//			List<ArticleDto> list = articleService.list();
//			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	
	@PutMapping("delete/{articleNo}")
	@ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> delete(@PathVariable int articleNo) {
		logger.debug("articleNo info : {}", articleNo);
		try {
			articleService.delete(articleNo);
			articleService.deletePhotos(articleNo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/detail/{articleNo}")
	@ApiOperation(value = "게시글 세부 정보", notes = "게시글의 세부 정보를 가져옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 세부 정보 OK"), @ApiResponse(code = 500, message = "서버 에러")})
//	post는 일단 body를 쓴다는 말이다.-> json에 담아보내고 @RequestBody으로 받는다
//	get은 body를 안쓰고 uri에 들어가니까 PathVariable로 받아야한다.
	public ResponseEntity<?> detail(@PathVariable int articleNo) {
		logger.debug("article detail Start");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("article", articleService.detail(articleNo));
			map.put("photos", articleService.getPhotos(articleNo));
			
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "게시글 목록", notes = "게시글의 목록을 가져옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 목록 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> list(BoardParameterDto boardParameterDto) {
		logger.debug("article list Start");
		System.out.println(boardParameterDto);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (boardParameterDto.getUserPosition() == null) boardParameterDto.setUserPosition("user");
			System.out.println(boardParameterDto);
			List<ArticleDto> list = articleService.list(boardParameterDto);
			PageNavigation pageNavigation = articleService.makePageNavigation(boardParameterDto.getPg(), boardParameterDto.getUserPosition());
			map.put("list", list);
			map.put("navigation", pageNavigation);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
