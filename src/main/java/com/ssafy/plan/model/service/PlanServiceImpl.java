package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day.model.mapper.DayMapper;
import com.ssafy.plan.model.DayDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.WaypointDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import com.ssafy.waypoint.model.mapper.WaypointMapper;

@Service
public class PlanServiceImpl implements PlanService{

	private PlanMapper planMapper;
	private DayMapper dayMapper;
	private WaypointMapper waypointMapper;

	public PlanServiceImpl(PlanMapper planMapper, DayMapper dayMapper, WaypointMapper waypointMapper) {
		super();
		this.planMapper = planMapper;
		this.dayMapper = dayMapper;
		this.waypointMapper = waypointMapper;
	}

	@Override
	public void writePlan(PlanDto planDto) {
		planMapper.writePlan(planDto);
	}

	@Override
	public void addDay(DayDto dayDto) {
		dayMapper.addDay(dayDto);
	}

	@Override
	public void addWaypoint(WaypointDto waypointDto) {
		waypointMapper.addWaypoint(waypointDto);
	}

	@Override
	public List<PlanDto> listPlan(int userId) {
		return planMapper.listPlan(userId);
	}

	@Override
	public PlanDto detailPlan(int planNo) {
		return planMapper.detailPlan(planNo);
	}

	@Override
	public List<DayDto> listDay(int planNo) {
		return dayMapper.listDay(planNo);
	}

	@Override
	public List<WaypointDto> listWaypoint(int dayNo) {
		return waypointMapper.listWaypoint(dayNo);
	}
	
	
}
