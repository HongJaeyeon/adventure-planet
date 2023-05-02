package com.ssafy.article.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.article.model.ArticleDto;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Override
	public void write(ArticleDto articleDto) throws Exception {
		
	}

	@Override
	public void modify(ArticleDto articleDto) throws Exception {
	}

	@Override
	public void delete(String articleNo) throws Exception {
	}

	@Override
	public ArticleDto detail(ArticleDto articleDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDto> list(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ArticleDto> listByAdmin() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
