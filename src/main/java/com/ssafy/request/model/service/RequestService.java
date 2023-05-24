package com.ssafy.request.model.service;

import java.util.List;

import com.ssafy.request.model.RequestDto;

public interface RequestService {

	void addRequest(RequestDto requestDto);

	List<RequestDto> listRequest(String userId);

	void deleteRequest(int requestNo);

}
