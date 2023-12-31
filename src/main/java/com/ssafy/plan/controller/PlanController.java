package com.ssafy.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.plan.model.DayDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.WaypointDto;
import com.ssafy.plan.model.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = {"여행 계획 API"})
public class PlanController {

	private PlanService planService;

	@Autowired
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/write")
	@ApiOperation(value = "여행 계획 등록", notes = "여행 계획을 등록합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 계획 등록 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> writePlan(@RequestBody PlanDto planDto) {

		try {
			planService.writePlan(planDto);
			int planNo = planDto.getPlanNo();
//			System.out.println("planNo : " + planNo);
//			if (planDto.getDays() != null) {
//				for (DayDto dayDto : planDto.getDays()) {
//					dayDto.setPlanNo(planNo);
//					planService.addDay(dayDto);
//					int dayNo = dayDto.getDayNo();
//					System.out.println("dayNo : " + dayNo);
//					if (dayDto.getWaypoints() != null) {
//						for (WaypointDto waypointDto : dayDto.getWaypoints()) {
//							waypointDto.setDayNo(dayNo);
//							planService.addWaypoint(waypointDto);
//						}
//					}
//				}
//			}

			return new ResponseEntity<Integer>(planNo, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	@PostMapping("/add/Day")
	@ApiOperation(value = "여행 계획에 날짜 추가", notes = "여행 계획에 날짜를 추가합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "날짜 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> addDay(@RequestBody DayDto dayDto) {

		try {
			System.out.println(dayDto);
			int dayOrder = planService.getNextDayOrder(dayDto.getPlanNo());
			dayDto.setDayOrder(dayOrder);
			planService.addDay(dayDto);
			int dayNo = dayDto.getDayNo();
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<DayDto> list = planService.listDay(dayDto.getPlanNo());
			
			map.put("dayNo", dayNo);
			map.put("days", list);
			
			System.out.println(map);

			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@GetMapping("/list/{userId}")
	@ApiOperation(value = "여행 계획 리스트 조회", notes = "사용자의 여행 계획을 조회합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 계획 조회 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> listPlan(@PathVariable String userId) {

		try {
			List<PlanDto> list = planService.listPlan(userId);

			return new ResponseEntity<List<PlanDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	@GetMapping("/list/Waypoint/{dayNo}")
	@ApiOperation(value = "여행 요소 리스트 조회", notes = "사용자의 여행 요소를 조회합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 요소 조회 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> listWaypoints(@PathVariable int dayNo) {
		
		try {
			List<WaypointDto> list = planService.listWaypoint(dayNo);
			
			return new ResponseEntity<List<WaypointDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}

	@GetMapping("/detail/{planNo}")
	@ApiOperation(value = "여행 계획 세부 조회", notes = "여행 계획을 세부 조회합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 계획 세부 조회 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> detailPlan(@PathVariable int planNo) {

		try {
			PlanDto planDto = planService.detailPlan(planNo);
			if (planDto != null) {
				planDto.setDays(planService.listDay(planNo));

				if (planDto.getDays() != null) {
					for (DayDto dayDto : planDto.getDays()) {
						dayDto.setWaypoints(planService.listWaypoint(dayDto.getDayNo()));
					}
				}
			}

			return new ResponseEntity<PlanDto>(planDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@PutMapping("/delete/{planNo}")
	@ApiOperation(value = "여행 계획 삭제", notes = "여행 계획을 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 계획 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> deletePlan(@PathVariable int planNo) {

		try {
			PlanDto planDto = planService.detailPlan(planNo);
			planDto.setDays(planService.listDay(planNo));

			if (planDto.getDays() != null) {
				for (DayDto dayDto : planDto.getDays()) {
					dayDto.setWaypoints(planService.listWaypoint(dayDto.getDayNo()));
				}
			}

			planService.deletePlan(planNo);

			for (DayDto dayDto : planDto.getDays()) {
				planService.deleteDay(dayDto.getDayNo());
				planService.deleteWaypoint(dayDto.getDayNo());
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	@PutMapping("/delete/Waypoint/{dayNo}")
	@ApiOperation(value = "여행 요소 전체 삭제", notes = "여행 요소를 모두 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "여행 요소 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> deleteWaypoint(@PathVariable int dayNo) {

		try {

			planService.deleteWaypoint(dayNo);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	@PostMapping("/add/Waypoint/{dayNo}")
	@ApiOperation(value = "여행 계획에 날짜 추가", notes = "여행 계획에 날짜를 추가합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "날짜 추가 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> addDay(@PathVariable int dayNo, @RequestBody Map<String, Object> map) {

		try {
			
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("addWaypointList");
			
			System.out.println(list);
			
			for (Map<String, Object> ele : list) {
				WaypointDto waypointDto = new WaypointDto();
				
				waypointDto.setContentId((int) ele.get("contentId"));
				waypointDto.setWaypointOrder((int) ele.get("waypointOrder"));				
				waypointDto.setDayNo(dayNo);
				
				System.out.println(waypointDto);
				
				planService.addWaypoint(waypointDto);
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
}
