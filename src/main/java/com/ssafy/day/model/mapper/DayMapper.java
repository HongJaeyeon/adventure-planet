package com.ssafy.day.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.DayDto;

@Mapper
public interface DayMapper {

	void addDay(DayDto dayDto);

}
