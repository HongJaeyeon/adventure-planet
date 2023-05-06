package com.ssafy.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WaypointDto (관광지 경로 정보)", description = "관광지 경로의 정보를 담는 클래스")
public class WaypointDto {

	@ApiModelProperty(value = "관광지 경로 번호")
	private int waypointNo;
	@ApiModelProperty(value = "여행 계획 번호")
	private int planNo;
	@ApiModelProperty(value = "관광지 번호")
	private int attractionContentId;
	@ApiModelProperty(value = "관광지 경로 순서")
	private int waypointOrder;
	@ApiModelProperty(value = "관광지 경로 내용")
	private String waypointContent;
	@ApiModelProperty(value = "관광지 경로 상태")
	private int waypointStatus;
	
	public WaypointDto() {	}

	public WaypointDto(int waypointNo, int planNo, int attractionContentId, int waypointOrder, String waypointContent,
			int waypointStatus) {
		super();
		this.waypointNo = waypointNo;
		this.planNo = planNo;
		this.attractionContentId = attractionContentId;
		this.waypointOrder = waypointOrder;
		this.waypointContent = waypointContent;
		this.waypointStatus = waypointStatus;
	}

	public int getWaypointNo() {
		return waypointNo;
	}

	public void setWaypointNo(int waypointNo) {
		this.waypointNo = waypointNo;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public int getAttractionContentId() {
		return attractionContentId;
	}

	public void setAttractionContentId(int attractionContentId) {
		this.attractionContentId = attractionContentId;
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

	@Override
	public String toString() {
		return "WaypointDto [waypointNo=" + waypointNo + ", planNo=" + planNo + ", attractionContentId="
				+ attractionContentId + ", waypointOrder=" + waypointOrder + ", waypointContent=" + waypointContent
				+ ", waypointStatus=" + waypointStatus + "]";
	}
	
	
}
