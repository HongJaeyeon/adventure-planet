package com.ssafy.article.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.article.model.ArticleDto;

public interface ArticleService {
	void write(ArticleDto articleDto) throws Exception;
	void modify(ArticleDto articleDto) throws Exception;
	void delete(String articleNo) throws Exception;
	
	//params : postion, articleNo, userId
	ArticleDto detail(ArticleDto articleDto) throws Exception;
	
	//params : postion, userId (리스트 화면에서 delete 삭제 버튼)
	List<ArticleDto> list(Map<String, String> map) throws Exception;
	
	//byAdmin
	List<ArticleDto> listByAdmin() throws Exception;
}
