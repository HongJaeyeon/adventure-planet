package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.user.model.UserDto;

public interface UserService {

	public int regist(UserDto member) throws SQLException;
	public UserDto login(String email) throws SQLException;
	public ArrayList<UserDto> list();
	public void detail();
	public boolean delete(UserDto member) throws SQLException;
	
}
