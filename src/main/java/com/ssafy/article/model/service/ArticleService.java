package com.ssafy.article.model.service;

import java.util.List;

import com.ssafy.article.model.ArticleDto;

public interface ArticleService {
	void write(ArticleDto articleDto) throws Exception;
	void modify(ArticleDto articleDto) throws Exception;
	void delete(int articleNo) throws Exception;
	
	//params : postion, articleNo, userId
	ArticleDto detail(int articleNo) throws Exception;
	
	//params : postion, userId (리스트 화면에서 delete 삭제 버튼) -> front에서 할일
	List<ArticleDto> list() throws Exception;
}
