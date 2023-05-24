package com.ssafy.plan.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlanDto (여행 계획 정보)", description = "여행 계획의 정보를 담는 클래스")
public class PlanDto implements Comparable<PlanDto>{
	
	@ApiModelProperty(value = "여행 계획 번호")
	private int planNo;
	@ApiModelProperty(value = "작성자: 유저 아이디")
	private String userId;
	@ApiModelProperty(value = "여행 계획 제목")
	private String planTitle;
	@ApiModelProperty(value = "여행 계획 상태")
	private int planStatus;
	@ApiModelProperty(value = "여행 계획 만든 시간")
	private String planCreateTime;
	@ApiModelProperty(value = "여행 계획 세부 내용")
	private String planContent;
	@ApiModelProperty(value = "여행 계획의 공유 여부")
	private boolean isShared;
	@ApiModelProperty(value = "여행 계획의 day")
	private List<DayDto> days;
	
	public PlanDto() {	}
	
	public PlanDto(int planNo, String userId, String planTitle, int planStatus, String planCreateTime,
			String planContent, boolean isShared, List<DayDto> days) {
		super();
		this.planNo = planNo;
		this.userId = userId;
		this.planTitle = planTitle;
		this.planStatus = planStatus;
		this.planCreateTime = planCreateTime;
		this.planContent = planContent;
		this.isShared = isShared;
		this.days = days;
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
	
	public String getPlanCreateTime() {
		return planCreateTime;
	}

	public void setPlanCreateTime(String planCreateTime) {
		this.planCreateTime = planCreateTime;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	
	public List<DayDto> getDays() {
		return days;
	}

	public void setDays(List<DayDto> days) {
		this.days = days;
	}
	
	public boolean getIsShared() {
		return isShared;
	}

	public void setIsShared(boolean isShared) {
		this.isShared = isShared;
	}

	@Override
	public String toString() {
		return "PlanDto [planNo=" + planNo + ", userId=" + userId + ", planTitle=" + planTitle + ", planStatus="
				+ planStatus + ", planCreateTime=" + planCreateTime + ", planContent=" + planContent + ", isShared="
				+ isShared + ", days=" + days + "]";
	}

	@Override
	public int compareTo(PlanDto o) {
		return -this.planCreateTime.compareTo(o.planCreateTime);
	}
	
	

	
}
