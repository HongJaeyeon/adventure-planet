package com.ssafy.plan.model;

import java.util.List;

public class PlanDto {
	
	private int planNo;
	private String userId;
	private String planTitle;
	private int planStatus;
	private List<WaypointDto> waypoints;
	
	public PlanDto() {	}

	public PlanDto(int planNo, String userId, String planTitle, int planStatus, List<WaypointDto> waypoints) {
		super();
		this.planNo = planNo;
		this.userId = userId;
		this.planTitle = planTitle;
		this.planStatus = planStatus;
		this.waypoints = waypoints;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public int getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(int planStatus) {
		this.planStatus = planStatus;
	}

	public List<WaypointDto> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<WaypointDto> waypoints) {
		this.waypoints = waypoints;
	}

	@Override
	public String toString() {
		return "PlanDto [planNo=" + planNo + ", userId=" + userId + ", planTitle=" + planTitle + ", planStatus="
				+ planStatus + ", waypoints=" + waypoints + "]";
	}
	
}
