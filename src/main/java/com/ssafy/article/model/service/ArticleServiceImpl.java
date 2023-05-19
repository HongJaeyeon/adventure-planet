package com.ssafy.article.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.mapper.ArticleMapper;
import com.ssafy.util.PageNavigation;

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
		articleMapper.hitCount(articleNo);
		return articleMapper.detail(articleNo);
	}

	@Override
	public List<ArticleDto> list(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return articleMapper.list(boardParameterDto);
	}
	
	@Override
	public PageNavigation makePageNavigation(int pgno, String userPosition) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = 5; // 몇개의 페이지가 보일건지
		int sizePerPage = 20; // 한 페이지에 몇개의 게시글이 보일건지
		int currentPage = pgno;

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = articleMapper.getTotalArticleCount(userPosition);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);

		return pageNavigation;
	}

}
