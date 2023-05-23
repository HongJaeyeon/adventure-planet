package com.ssafy.waypoint.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.WaypointDto;

@Mapper
public interface WaypointMapper {

	void addWaypoint(WaypointDto waypointDto);

	List<WaypointDto> listWaypoint(int dayNo);

}
