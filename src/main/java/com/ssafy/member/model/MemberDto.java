package com.ssafy.member.model;

public class MemberDto {

	private int user_id; //int
	private String email; //실제 로그인
	private String nickname;
	private String password;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MemberDto [user_id=" + user_id + ", email=" + email + ", nickname=" + nickname + ", password="
				+ password + "]";
	}
	
	
	
}
