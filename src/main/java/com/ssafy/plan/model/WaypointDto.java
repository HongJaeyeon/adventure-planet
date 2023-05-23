package com.ssafy.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WaypointDto (관광지 경로 정보)", description = "관광지 경로의 정보를 담는 클래스")
public class WaypointDto {

	@ApiModelProperty(value = "관광지 경로 번호")
	private int waypointNo;
	@ApiModelProperty(value = "속한 여행 계획의 Day 번호")
	private int dayNo;
	@ApiModelProperty(value = "관광지 번호")
	private int contentId;
	@ApiModelProperty(value = "관광지 경로 순서")
	private int waypointOrder;
	@ApiModelProperty(value = "관광지 경로 내용")
	private String waypointContent;
	@ApiModelProperty(value = "관광지 경로 상태")
	private int waypointStatus;
	@ApiModelProperty(value = "관광지 추가한 시간")
	private String waypointAddTime;
	
	public WaypointDto() {	}

	public WaypointDto(int waypointNo, int dayNo, int contentId, int waypointOrder, String waypointContent,
			int waypointStatus, String waypointAddTime) {
		super();
		this.waypointNo = waypointNo;
		this.dayNo = dayNo;
		this.contentId = contentId;
		this.waypointOrder = waypointOrder;
		this.waypointContent = waypointContent;
		this.waypointStatus = waypointStatus;
		this.waypointAddTime = waypointAddTime;
	}

	public int getWaypointNo() {
		return waypointNo;
	}

	public void setWaypointNo(int waypointNo) {
		this.waypointNo = waypointNo;
	}

	public int getWaypointOrder() {
		return waypointOrder;
	}

	public void setWaypointOrder(int waypointOrder) {
		this.waypointOrder = waypointOrder;
	}

	public String getWaypointContent() {
		return waypointContent;
	}

	public void setWaypointContent(String waypointContent) {
		this.waypointContent = waypointContent;
	}

	public int getWaypointStatus() {
		return waypointStatus;
	}

	public void setWaypointStatus(int waypointStatus) {
		this.waypointStatus = waypointStatus;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getWaypointAddTime() {
		return waypointAddTime;
	}

	public void setWaypointAddTime(String waypointAddTime) {
		this.waypointAddTime = waypointAddTime;
	}

	@Override
	public String toString() {
		return "WaypointDto [waypointNo=" + waypointNo + ", dayNo=" + dayNo + ", contentId=" + contentId
				+ ", waypointOrder=" + waypointOrder + ", waypointContent=" + waypointContent + ", waypointStatus="
				+ waypointStatus + ", waypointAddTime=" + waypointAddTime + "]";
	}

}
