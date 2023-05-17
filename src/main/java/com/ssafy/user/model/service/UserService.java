package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.user.model.UserDto;

public interface UserService {

	public UserDto regist(UserDto userDto) throws SQLException;
	public UserDto login(UserDto userDto) throws SQLException;
	public List<UserDto> list();
	public UserDto detail(String userId);
	public UserDto leave(String userId) throws SQLException;
	public UserDto update(UserDto userDto);
	public UserDto userInfo(String userId) throws Exception;
	public void saveRefreshToken(String userId, String refreshToken);
	public Object getRefreshToken(String userId) throws Exception;
	public void deleRefreshToken(String userId) throws Exception;
	
}
