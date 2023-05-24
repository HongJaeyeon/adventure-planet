package com.ssafy.request.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RequestDto (요청 정보)", description = "요청의 정보를 담는 클래스")
public class RequestDto {
	
	@ApiModelProperty(value = "요청 번호")
	private int requestNo;
	@ApiModelProperty(value = "요청한 유저 id")
	private String fromUserId;
	@ApiModelProperty(value = "공유하고 싶은 여행 계획 번홀 ㅈㄷ")
	private int planNo;
	@ApiModelProperty(value = "공유하고 싶은 여행 계획 이름")
	private String planTitle;
	@ApiModelProperty(value = "요청받은 유저 id")
	private String toUserId;
	@ApiModelProperty(value = "요청한 상태")
	private int requestStatus;
	@ApiModelProperty(value = "요청한 시간")
	private String requestCreateTime;
	
	public RequestDto() {	}

	public RequestDto(int requestNo, String fromUserId, int planNo, String planTitle, String toUserId,
			int requestStatus, String requestCreateTime) {
		super();
		this.requestNo = requestNo;
		this.fromUserId = fromUserId;
		this.planNo = planNo;
		this.planTitle = planTitle;
		this.toUserId = toUserId;
		this.requestStatus = requestStatus;
		this.requestCreateTime = requestCreateTime;
	}

	public int getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
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

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public int getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestCreateTime() {
		return requestCreateTime;
	}

	public void setRequestCreateTime(String requestCreateTime) {
		this.requestCreateTime = requestCreateTime;
	}

	@Override
	public String toString() {
		return "RequestDto [requestNo=" + requestNo + ", fromUserId=" + fromUserId + ", planNo=" + planNo
				+ ", planTitle=" + planTitle + ", toUserId=" + toUserId + ", requestStatus=" + requestStatus
				+ ", requestCreateTime=" + requestCreateTime + "]";
	}
	
}
