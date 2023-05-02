package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Member;

public interface UserService {

	public int regist(Member member) throws SQLException;
	public Member login(String email) throws SQLException;
	public ArrayList<Member> list();
	public void detail();
	public boolean delete(Member member) throws SQLException;
	
}
