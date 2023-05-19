package com.ssafy.article.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardParameterDto : 게시판 파라미터 정보", description = "게시판의 글을 얻기위한 부가적인 파라미터정보.")
public class BoardParameterDto {

	@ApiModelProperty(value = "현재 페이지 번호")
	private int pg;
	@ApiModelProperty(value = "페이지당 글갯수")
	private int spp;
	@ApiModelProperty(value = "페이지의 시작 글번호")
	private int start;
	@ApiModelProperty(value = "게시글상태")
	private int articleStatus;
	@ApiModelProperty(value = "유저권한")
	private String userPosition;
	
	public BoardParameterDto() {
		pg = 1;
		spp = 20;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		pg = pg == 0 ? 1 : pg;
		this.pg = pg;
	}

	public int getSpp() {
		return spp;
	}

	public void setSpp(int spp) {
		this.spp = spp;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(int articleStatus) {
		this.articleStatus = articleStatus;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	@Override
	public String toString() {
		return "BoardParameterDto [pg=" + pg + ", spp=" + spp + ", start=" + start + ", articleStatus=" + articleStatus
				+ ", userPosition=" + userPosition + "]";
	}

}

