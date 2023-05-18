package com.ssafy.article.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArticleDto (게시글 정보)", description = "게시글의 정보를 담는 클래스")
public class ArticleDto {
	
	@ApiModelProperty(value = "게시글 번호")
	private int articleNo;
	@ApiModelProperty(value = "작성자: 유저 아이디")
	private String userId;
	@ApiModelProperty(value = "게시글 제목")
	private String articleTitle;
	@ApiModelProperty(value = "게시글 내용")
	private String articleContent;
	@ApiModelProperty(value = "게시글 상태")
	private int articleStatus;
	@ApiModelProperty(value = "게시글 조회수")
	private int articleHit;
	@ApiModelProperty(value = "게시글 작성 시간")
	private String articleWriteTime;
	@ApiModelProperty(value = "게시글 작성 시간과 현재 시간의 차")
	private String articleWriteTimeAgo;
	
	public ArticleDto() {}
	
	public ArticleDto(int articleNo, String userId, String articleTitle, String articleContent, int articleStatus,
			int articleHit, String articleWriteTime, String articleWriteTimeAgo) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleStatus = articleStatus;
		this.articleHit = articleHit;
		this.articleWriteTime = articleWriteTime;
		this.articleWriteTimeAgo = articleWriteTimeAgo;
	}

	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getArticleStatus() {
		return articleStatus;
	}
	public void setArticleStatus(int articleStatus) {
		this.articleStatus = articleStatus;
	}
	
	public int getArticleHit() {
		return articleHit;
	}

	public void setArticleHit(int articleHit) {
		this.articleHit = articleHit;
	}

	public String getArticleWriteTime() {
		return articleWriteTime;
	}

	public void setArticleWriteTime(String articleWriteTime) {
		this.articleWriteTime = articleWriteTime;
	}

	public String getArticleWriteTimeAgo() {
		return articleWriteTimeAgo;
	}

	public void setArticleWriteTimeAgo(String articleWriteTimeAgo) {
		this.articleWriteTimeAgo = articleWriteTimeAgo;
	}

	@Override
	public String toString() {
		return "ArticleDto [articleNo=" + articleNo + ", userId=" + userId + ", articleTitle=" + articleTitle
				+ ", articleContent=" + articleContent + ", articleStatus=" + articleStatus + ", articleHit="
				+ articleHit + ", articleWriteTime=" + articleWriteTime + ", articleWriteTimeAgo=" + articleWriteTimeAgo
				+ "]";
	}
	
}
