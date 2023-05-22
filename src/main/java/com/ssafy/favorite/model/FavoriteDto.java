package com.ssafy.favorite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FavoriteDto (찜 정보)", description = "찜의 정보를 담는 클래스")
public class FavoriteDto {
	
	@ApiModelProperty(value = "찜 번호")
	private int favoriteNo;
	@ApiModelProperty(value = "찜한 유저 id")
	private String userId;
	@ApiModelProperty(value = "찜한 관광징 id")
	private int contentId;
	@ApiModelProperty(value = "찜한 상태")
	private int favoriteStatus;
	@ApiModelProperty(value = "찜한 시간")
	private String favoriteAddTime;
	
	public FavoriteDto() {	}

	public FavoriteDto(int favoriteNo, String userId, int contentId, int favoriteStatus, String favoriteAddTime) {
		super();
		this.favoriteNo = favoriteNo;
		this.userId = userId;
		this.contentId = contentId;
		this.favoriteStatus = favoriteStatus;
		this.favoriteAddTime = favoriteAddTime;
	}

	public int getFavoriteNo() {
		return favoriteNo;
	}

	public void setFavoriteNo(int favoriteNo) {
		this.favoriteNo = favoriteNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getFavoriteStatus() {
		return favoriteStatus;
	}

	public void setFavoriteStatus(int favoriteStatus) {
		this.favoriteStatus = favoriteStatus;
	}

	public String getFavoriteAddTime() {
		return favoriteAddTime;
	}

	public void setFavoriteAddTime(String favoriteAddTime) {
		this.favoriteAddTime = favoriteAddTime;
	}

	@Override
	public String toString() {
		return "FavoriteDto [favoriteNo=" + favoriteNo + ", userId=" + userId + ", contentId=" + contentId
				+ ", favoriteStatus=" + favoriteStatus + ", favoriteAddTime=" + favoriteAddTime + "]";
	}
	
}
