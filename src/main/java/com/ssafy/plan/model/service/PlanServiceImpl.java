package com.ssafy.plan.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.day.model.mapper.DayMapper;
import com.ssafy.plan.model.DayDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.WaypointDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import com.ssafy.share.model.mapper.ShareMapper;
import com.ssafy.waypoint.model.mapper.WaypointMapper;

@Service
public class PlanServiceImpl implements PlanService{

	private PlanMapper planMapper;
	private DayMapper dayMapper;
	private WaypointMapper waypointMapper;
	private ShareMapper shareMapper;

	public PlanServiceImpl(PlanMapper planMapper, DayMapper dayMapper, WaypointMapper waypointMapper,
			ShareMapper shareMapper) {
		super();
		this.planMapper = planMapper;
		this.dayMapper = dayMapper;
		this.waypointMapper = waypointMapper;
		this.shareMapper = shareMapper;
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
	public List<PlanDto> listPlan(String userId) {

		List<PlanDto> list = planMapper.listPlan(userId);

		List<Integer> sharedPlanNo = shareMapper.listShare(userId);

		System.out.println(sharedPlanNo);

		for (int planNo : sharedPlanNo) {
			PlanDto planDto = planMapper.detailPlan(planNo);

			if (planDto != null) {
				planDto.setIsShared(true);
				list.add(planDto);
			}
		}

		Collections.sort(list);

		return list;
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
	public void deletePlan(int planNo) {
		planMapper.deletePlan(planNo);
	}

	@Override
	public void deleteDay(int dayNo) {
		dayMapper.deleteDay(dayNo);
	}

	@Override
	public void deleteWaypoint(int dayNo) {
		waypointMapper.deleteWaypoint(dayNo);
	}

	@Override
	public int getNextDayOrder(int planNo) {
		return dayMapper.getNextDayOrder(planNo);
	}

	@Override
	public List<WaypointDto> listWaypoint(int dayNo) {
		return waypointMapper.listWaypoint(dayNo);
	}

}
