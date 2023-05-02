package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private static UserMapper userMapper;
	
	
	
	@Override
	public int regist(UserDto user) throws SQLException {
		return userMapper.regist(user);
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
	public void detail() {
		userMapper.detail();
	}

	@Override
	public boolean delete(UserDto user) throws SQLException {
		return userMapper.delete(user);
	}
	
}
