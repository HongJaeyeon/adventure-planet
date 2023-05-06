package com.ssafy.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/plan")
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
			PlanDto newPlanDto = planService.writePlan(planDto);
			
			return new ResponseEntity<PlanDto>(newPlanDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
}
