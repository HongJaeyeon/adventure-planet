package com.ssafy.plan.model;

public class WaypointDto {

	private int waypointNo;
	private int planNo;
	private int attractionContentId;
	private int waypointOrder;
	private String waypointContent;
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
