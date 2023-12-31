package com.ssafy.article.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.article.model.ArticleDto;
import com.ssafy.article.model.BoardParameterDto;
import com.ssafy.article.model.PhotoDto;
import com.ssafy.article.model.mapper.ArticleMapper;
import com.ssafy.util.PageNavigation;

@Service
public class ArticleServiceImpl implements ArticleService {
	private ArticleMapper articleMapper;
	
	private final AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public ArticleServiceImpl(ArticleMapper articleMapper) {
		super();
		this.amazonS3Client = new AmazonS3Client();
		this.articleMapper = articleMapper;
	}
	
	@Override
	@Transactional
	public String uploadImage(MultipartFile multipartFile, int articleNo) throws IOException {
		String origName = multipartFile.getOriginalFilename();
		final String ext = origName.substring(origName.lastIndexOf('.'));
		String profile_image_name = UUID.randomUUID().toString() + ext;
		ObjectMetadata objMeta = new ObjectMetadata();
		InputStream stream = multipartFile.getInputStream();
		objMeta.setContentLength(stream.available());
		amazonS3Client.putObject(bucket, profile_image_name, stream, objMeta);
		stream.close();
		articleMapper.addPhoto(articleNo, amazonS3Client.getUrl(bucket, profile_image_name).toString(), origName);
		return amazonS3Client.getUrl(bucket, profile_image_name).toString();
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

	@Override
	public List<PhotoDto> getPhotos(int articleNo) {
		return articleMapper.getPhotos(articleNo);
	}

	@Override
	public void deletePhotos(int articleNo) {
		articleMapper.deletePhotos(articleNo);
	}

}
