package com.ssafy.plan.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.PlanDto;

@Mapper
public interface PlanMapper {

	void writePlan(PlanDto planDto);

	List<PlanDto> listPlan(int userId);

}
