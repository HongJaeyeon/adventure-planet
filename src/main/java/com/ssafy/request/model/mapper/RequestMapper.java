package com.ssafy.request.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.request.model.RequestDto;

@Mapper
public interface RequestMapper {

	void addRequest(RequestDto requestDto);

	List<RequestDto> listRequest(String userId);

	void deleteRequest(int requestNo);

}
