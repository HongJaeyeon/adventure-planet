package com.ssafy.request.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.favorite.model.mapper.FavoriteMapper;
import com.ssafy.request.model.RequestDto;
import com.ssafy.request.model.mapper.RequestMapper;

@Service
public class RequestServiceImpl implements RequestService {
	private RequestMapper requestMapper;

	public RequestServiceImpl(RequestMapper requestMapper) {
		super();
		this.requestMapper = requestMapper;
	}

	@Override
	public void addRequest(RequestDto requestDto) {
		requestMapper.addRequest(requestDto);
	}

	@Override
	public List<RequestDto> listRequest(String userId) {
		return requestMapper.listRequest(userId);
	}

	@Override
	public void deleteRequest(int requestNo) {
		requestMapper.deleteRequest(requestNo);
	}	
	
}
