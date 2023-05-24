package com.ssafy.share.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ShareDto (공유 정보)", description = "공유의 정보를 담는 클래스")
public class ShareDto {
	
	@ApiModelProperty(value = "요청 번호")
	private int shareNo;
	@ApiModelProperty(value = "요청한 유저 id")
	private String fromUserId;
	@ApiModelProperty(value = "공유하고 싶은 여행 계획 번홀 ㅈㄷ")
	private int planNo;
	@ApiModelProperty(value = "요청받은 유저 id")
	private String toUserId;
	@ApiModelProperty(value = "요청한 상태")
	private int shareStatus;
	@ApiModelProperty(value = "요청한 시간")
	private String shareCreateTime;
	
	public ShareDto() {	}

	public ShareDto(int shareNo, String fromUserId, int planNo, String toUserId, int shareStatus,
			String shareCreateTime) {
		super();
		this.shareNo = shareNo;
		this.fromUserId = fromUserId;
		this.planNo = planNo;
		this.toUserId = toUserId;
		this.shareStatus = shareStatus;
		this.shareCreateTime = shareCreateTime;
	}

	public int getShareNo() {
		return shareNo;
	}

	public void setShareNo(int shareNo) {
		this.shareNo = shareNo;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public int getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(int shareStatus) {
		this.shareStatus = shareStatus;
	}

	public String getShareCreateTime() {
		return shareCreateTime;
	}

	public void setShareCreateTime(String shareCreateTime) {
		this.shareCreateTime = shareCreateTime;
	}

	@Override
	public String toString() {
		return "ShareDto [shareNo=" + shareNo + ", fromUserId=" + fromUserId + ", planNo=" + planNo + ", toUserId="
				+ toUserId + ", shareStatus=" + shareStatus + ", shareCreateTime=" + shareCreateTime + "]";
	}

}
