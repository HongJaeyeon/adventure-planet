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
	
	@ApiModelProperty(value = "관광지 이름")
	private String contentTitle;
	@ApiModelProperty(value = "관광지 주소")
	private String contentAddr1;
	@ApiModelProperty(value = "관광지 사진")
	private String contentFirstImage;
	
	public WaypointDto() {	}

	public WaypointDto(int waypointNo, int dayNo, int contentId, int waypointOrder, String waypointContent,
			int waypointStatus, String waypointAddTime, String contentTitle, String contentAddr1,
			String contentFirstImage) {
		super();
		this.waypointNo = waypointNo;
		this.dayNo = dayNo;
		this.contentId = contentId;
		this.waypointOrder = waypointOrder;
		this.waypointContent = waypointContent;
		this.waypointStatus = waypointStatus;
		this.waypointAddTime = waypointAddTime;
		this.contentTitle = contentTitle;
		this.contentAddr1 = contentAddr1;
		this.contentFirstImage = contentFirstImage;
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
	
	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentAddr1() {
		return contentAddr1;
	}

	public void setContentAddr1(String contentAddr1) {
		this.contentAddr1 = contentAddr1;
	}

	public String getContentFirstImage() {
		return contentFirstImage;
	}

	public void setContentFirstImage(String contentFirstImage) {
		this.contentFirstImage = contentFirstImage;
	}

	@Override
	public String toString() {
		return "WaypointDto [waypointNo=" + waypointNo + ", dayNo=" + dayNo + ", contentId=" + contentId
				+ ", waypointOrder=" + waypointOrder + ", waypointContent=" + waypointContent + ", waypointStatus="
				+ waypointStatus + ", waypointAddTime=" + waypointAddTime + ", contentTitle=" + contentTitle
				+ ", contentAddr1=" + contentAddr1 + ", contentFirstImage=" + contentFirstImage + "]";
	}

}
