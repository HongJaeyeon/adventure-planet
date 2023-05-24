package com.ssafy.share.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.request.model.RequestDto;
import com.ssafy.share.model.ShareDto;

@Mapper
public interface ShareMapper {

	void addShare(ShareDto shareDto);

}
