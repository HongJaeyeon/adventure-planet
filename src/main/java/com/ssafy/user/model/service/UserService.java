package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.user.model.UserDto;

public interface UserService {

	public UserDto regist(Map<String, Object> map) throws SQLException;
	public UserDto login(String email) throws SQLException;
	public ArrayList<UserDto> list();
	public void detail(String userId);
	public boolean delete(UserDto member) throws SQLException;
	
}
