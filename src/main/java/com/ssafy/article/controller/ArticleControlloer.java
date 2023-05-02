package com.ssafy.article.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleControlloer {
	private final Logger logger = LoggerFactory.getLogger(ArticleControlloer.class);
	
	private ArticleService articleService;
	
	public ArticleControlloer(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	
	@PostMapping("/write")
	public ResponseEntity<?> write(ArticleDto articleDto) {
		logger.debug("articleDto info : {}", articleDto);
		try {
			articleService.write(articleDto);
			List<ArticleDto> list = articleService.listByAdmin();
			return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	
	
	@GetMapping("/listbyadmin")
	public ResponseEntity<?> listByAdmin() {
		logger.debug("article lisyByAdmin Start");
		try {
			List<ArticleDto> list = articleService.listByAdmin();
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
