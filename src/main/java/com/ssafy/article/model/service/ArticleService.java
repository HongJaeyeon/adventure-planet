package com.ssafy.article.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.PhotoDto;
import com.ssafy.util.PageNavigation;

public interface ArticleService {
	void write(ArticleDto articleDto) throws Exception;
	void modify(ArticleDto articleDto) throws Exception;
	void delete(int articleNo) throws Exception;
	
	//params : postion, articleNo, userId
	ArticleDto detail(int articleNo) throws Exception;
	
	//params : postion, userId (리스트 화면에서 delete 삭제 버튼) -> front에서 할일
	List<ArticleDto> list(BoardParameterDto boardParameterDto) throws Exception;
	
	PageNavigation makePageNavigation(int pgno, String userPosition) throws Exception;
	
	String uploadImage(MultipartFile multipartFile, int articleNo) throws IOException;
	
	List<PhotoDto> getPhotos(int articleNo);
	
	void deletePhotos(int articleNo);
}
