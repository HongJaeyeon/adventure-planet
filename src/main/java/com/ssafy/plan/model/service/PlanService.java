package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.model.DayDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.WaypointDto;

public interface PlanService {

	void writePlan(PlanDto planDto);

	void addDay(DayDto dayDto);

	void addWaypoint(WaypointDto waypointDto);

	List<PlanDto> listPlan(int userId);

	PlanDto detailPlan(int planNo);

	List<DayDto> listDay(int planNo);

	List<WaypointDto> listWaypoint(int dayNo);

	void deletePlan(int planNo);

	void deleteDay(int dayNo);

	void deleteWaypoint(int waypointNo);

}
