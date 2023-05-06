package com.ssafy.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto (유저 정보)", description = "유저의 정보를 담는 클래스")
public class UserDto {

	@ApiModelProperty(value = "유저 아이디")
	private String userId;
	@ApiModelProperty(value = "유저 이메일")
	private String userEmail;
	@ApiModelProperty(value = "유저 비밀번호")
	private String userPassword;
	@ApiModelProperty(value = "유저 이름")
	private String userName;
	@ApiModelProperty(value = "유저 권한")
	private String userPosition;
	@ApiModelProperty(value = "유저 상태")
	private int userStatus;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String userId, String userEmail, String userPassword, String userName, String userPosition,
			int userStatus) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPosition = userPosition;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userPosition=" + userPosition + ", userStatus=" + userStatus + "]";
	}
	
}
