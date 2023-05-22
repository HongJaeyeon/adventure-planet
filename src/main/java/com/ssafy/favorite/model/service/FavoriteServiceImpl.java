package com.ssafy.favorite.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.PhotoDto;
import com.ssafy.article.model.mapper.ArticleMapper;
import com.ssafy.favorite.model.mapper.FavoriteMapper;
import com.ssafy.util.PageNavigation;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	private FavoriteMapper favoriteMapper;

	public FavoriteServiceImpl(FavoriteMapper favoriteMapper) {
		super();
		this.favoriteMapper = favoriteMapper;
	}
	
	
}
