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

@RestController
@RequestMapping("/plan")
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
	public ResponseEntity<?> writePlan(@RequestBody PlanDto planDto) {
		
		try {
			PlanDto newPlanDto = planService.writePlan(planDto);
			
			return new ResponseEntity<PlanDto>(newPlanDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
}
