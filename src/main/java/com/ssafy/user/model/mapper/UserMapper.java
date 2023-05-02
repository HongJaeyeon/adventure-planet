package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Member;

public interface UserMapper {
	
	public int regist(Member member) throws SQLException;
	public Member login(String email) throws SQLException;
	public ArrayList<Member> list();
	public void detail();
	public boolean delete(Member member) throws SQLException;

}
