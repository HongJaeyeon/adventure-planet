package com.ssafy.share.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.share.model.ShareDto;

@Mapper
public interface ShareMapper {

	void addShare(ShareDto shareDto);

	List<Integer> listShare(String userId);

}
