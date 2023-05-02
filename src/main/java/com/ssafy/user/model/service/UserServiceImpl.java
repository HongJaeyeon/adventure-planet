package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

public class UserServiceImpl {
	
	private static MemberService memberService = new MemberServiceImpl();
	private static MemberDao memberDao = MemberDaoImpl.getInstance();
	
	public MemberServiceImpl() {}
	
	public static MemberService getInstance() {
		return memberService;
	}	
	
	@Override
	public int regist(Member member) throws SQLException {
		return memberDao.regist(member);
	}
	
	@Override
	public Member login(String email) throws SQLException {
		return memberDao.login(email);
	}

	@Override
	public ArrayList<Member> list() {
		memberDao.list();
		return null;
	}

	@Override
	public void detail() {
		memberDao.detail();
	}

	@Override
	public boolean delete(Member member) throws SQLException {
		return memberDao.delete(member);
	}
	
}
