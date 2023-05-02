package com.ssafy.article.model;

public class ArticleDto {
	private int articleNo;
	private String userId;
	private String articleTitle;
	private String articleContent;
	private int articleStatus;
	
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
	
	@Override
	public String toString() {
		return "ArticleDto [articleNo=" + articleNo + ", userId=" + userId + ", articleTitle=" + articleTitle
				+ ", articleContent=" + articleContent + ", articleStatus=" + articleStatus + "]";
	}
	
}
