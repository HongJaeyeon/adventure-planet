package com.ssafy.request.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
