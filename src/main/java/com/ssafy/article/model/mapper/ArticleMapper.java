package com.ssafy.article.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.PhotoDto;

@Mapper
public interface ArticleMapper {
	int write(ArticleDto articleDto) throws Exception;
	void modify(ArticleDto articleDto) throws Exception;
	void delete(int articleNo) throws Exception;
	
	//params : postion, articleNo, userId
	ArticleDto detail(int articleNo) throws Exception;
	
	//params : postion, userId (리스트 화면에서 delete 삭제 버튼)
	List<ArticleDto> list(BoardParameterDto boardParameterDto) throws Exception;
	
	void hitCount (int articleNo) throws Exception;
	
	int getTotalArticleCount(String userPosition);
	
	int addPhoto(int articleNo, String photoSaveName, String photoOriginalName);
	
	List<PhotoDto> getPhotos(int articleNo);
	
	// 게시글이 지워질 때 같이 지워지기
	void deletePhotos(int articleNo);

}
