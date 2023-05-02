package com.ssafy.article.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService {
	private ArticleMapper articleMapper;
	
	public ArticleServiceImpl(ArticleMapper articleMapper) {
		super();
		this.articleMapper = articleMapper;
	}
	

	@Override
	public void write(ArticleDto articleDto) throws Exception {
		articleMapper.write(articleDto);
	}

	@Override
	public void modify(ArticleDto articleDto) throws Exception {
		articleMapper.modify(articleDto);
	}

	@Override
	public void delete(int articleNo) throws Exception {
		articleMapper.delete(articleNo);	
	}
	

	@Override
	public ArticleDto detail(int articleNo) throws Exception {
		return articleMapper.detail(articleNo);
	}


	@Override
	public List<ArticleDto> list() throws Exception {
		return articleMapper.list();
	}
}
