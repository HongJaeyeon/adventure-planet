package com.ssafy.day.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.DayDto;

@Mapper
public interface DayMapper {

	void addDay(DayDto dayDto);

	List<DayDto> listDay(int planNo);

	void deleteDay(int dayNo);

}
