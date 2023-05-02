package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	
	public int regist(Map<String, Object> map) throws SQLException;
	public UserDto login(String email) throws SQLException;
	public ArrayList<UserDto> list();
	public UserDto detail(String userId);
	public boolean delete(UserDto member) throws SQLException;

}
