package com.ssafy.plan.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlanDto (여행 계획 정보)", description = "여행 계획의 정보를 담는 클래스")
public class PlanDto {
	
	@ApiModelProperty(value = "여행 계획 번호")
	private int planNo;
	@ApiModelProperty(value = "작성자: 유저 아이디")
	private String userId;
	@ApiModelProperty(value = "여행 계획 제목")
	private String planTitle;
	@ApiModelProperty(value = "여행 계획 상태")
	private int planStatus;
	@ApiModelProperty(value = "관광지 경로 리스트")
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
