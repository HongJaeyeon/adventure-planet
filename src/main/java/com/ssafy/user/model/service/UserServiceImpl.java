package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public UserDto regist(Map<String, Object> map) throws SQLException {
		userMapper.regist(map);
		return userMapper.detail((String) map.get("userId"));
	}
	
	@Override
	public UserDto login(String email) throws SQLException {
		return userMapper.login(email);
	}

	@Override
	public ArrayList<UserDto> list() {
		userMapper.list();
		return null;
	}

	@Override
	public void detail(String userId) {
		userMapper.detail(userId);
	}

	@Override
	public boolean delete(UserDto user) throws SQLException {
		return userMapper.delete(user);
	}
	
}
