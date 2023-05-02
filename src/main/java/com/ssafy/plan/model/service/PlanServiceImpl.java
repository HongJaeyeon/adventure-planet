package com.ssafy.plan.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService{

	private PlanMapper planMapper;

	@Autowired
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public PlanDto writePlan(PlanDto planDto) {
		return planMapper.writePlan(planDto);
	}
	
	
}
