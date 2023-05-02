package com.ssafy.article.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	
	@PostMapping("/write")
	//자원 요청의 body에 담아 오기에 @RequestBody
	public ResponseEntity<?> write(@RequestBody ArticleDto articleDto) {
		logger.debug("articleDto info : {}", articleDto);
		try {
			articleService.write(articleDto);
			List<ArticleDto> list = articleService.list();
			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@PutMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody ArticleDto articleDto) {
		logger.debug("articleDto info : {}", articleDto);
		try {
			articleService.modify(articleDto);
			List<ArticleDto> list = articleService.list();
			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
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
	public ResponseEntity<?> delete(@PathVariable int articleNo) {
		logger.debug("articleNo info : {}", articleNo);
		try {
			articleService.delete(articleNo);
			List<ArticleDto> list = articleService.list();
			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@GetMapping("/detail/{articleNo}")
//	post는 일단 body를 쓴다는 말이다.-> json에 담아보내고 @RequestBody으로 받는다
//	get은 body를 안쓰고 uri에 들어가니까 PathVariable로 받아야한다.
	public ResponseEntity<?> detail(@PathVariable int articleNo) {
		logger.debug("article detail Start");
		try {
			return new ResponseEntity<ArticleDto>(articleService.detail(articleNo), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> listByAdmin() {
		logger.debug("article list Start");
		try {
			List<ArticleDto> list = articleService.list();
			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
