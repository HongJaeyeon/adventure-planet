package com.ssafy.waypoint.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.WaypointDto;

@Mapper
public interface WaypointMapper {

	void addWaypoint(WaypointDto waypointDto);

}
