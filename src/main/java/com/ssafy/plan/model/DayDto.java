package com.ssafy.plan.model;

import io.swagger.annotations.ApiModelProperty;

public class DayDto {
	
	@ApiModelProperty(value = "계획의 하루 번호")
	private int dayNo;
	@ApiModelProperty(value = "속한 계획의 번호")
	private int planNo;
	@ApiModelProperty(value = "하루의 순서")
	private int dayOrder;
	@ApiModelProperty(value = "하루의 날짜")
	private String dayDate;
	@ApiModelProperty(value = "하루의 상태")
	private int dayStatus;
	@ApiModelProperty(value = "하루가 추가된 시간")
	private String dayAddTime;
	
	public DayDto() {	}

	public DayDto(int dayNo, int planNo, int dayOrder, String dayDate, int dayStatus, String dayAddTime) {
		super();
		this.dayNo = dayNo;
		this.planNo = planNo;
		this.dayOrder = dayOrder;
		this.dayDate = dayDate;
		this.dayStatus = dayStatus;
		this.dayAddTime = dayAddTime;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public int getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(int dayOrder) {
		this.dayOrder = dayOrder;
	}

	public String getDayDate() {
		return dayDate;
	}

	public void setDayDate(String dayDate) {
		this.dayDate = dayDate;
	}

	public int getDayStatus() {
		return dayStatus;
	}

	public void setDayStatus(int dayStatus) {
		this.dayStatus = dayStatus;
	}

	public String getDayAddTime() {
		return dayAddTime;
	}

	public void setDayAddTime(String dayAddTime) {
		this.dayAddTime = dayAddTime;
	}

	@Override
	public String toString() {
		return "DayDto [dayNo=" + dayNo + ", planNo=" + planNo + ", dayOrder=" + dayOrder + ", dayDate=" + dayDate
				+ ", dayStatus=" + dayStatus + ", dayAddTime=" + dayAddTime + "]";
	}
	
	
}
