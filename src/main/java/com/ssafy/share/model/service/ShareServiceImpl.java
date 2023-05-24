package com.ssafy.share.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.share.model.ShareDto;
import com.ssafy.share.model.mapper.ShareMapper;

@Service
public class ShareServiceImpl implements ShareService {
	private ShareMapper shareMapper;

	public ShareServiceImpl(ShareMapper shareMapper) {
		super();
		this.shareMapper = shareMapper;
	}

	@Override
	public void addShare(ShareDto shareDto) {
		shareMapper.addShare(shareDto);
	}
	
}
