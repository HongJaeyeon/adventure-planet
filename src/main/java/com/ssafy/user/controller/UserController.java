package com.ssafy.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;
import com.ssafy.util.Crypt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(tags = {"유저 API"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
//	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	private Crypt crypt;

	public UserController(UserService userService, Crypt crypt) {
		super();
		this.userService = userService;
		this.crypt = crypt;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/regist")
	@ApiOperation(value = "유저 등록", notes = "유저를 등록합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 등록 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> regist(@RequestBody UserDto userDto) {
		try {
			UserDto resultUserDto = userService.regist(userDto);
			return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "유저 로그인", notes = "유저가 로그인합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 로그인 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		try {
			UserDto resultUserDto = userService.login(userDto);
			if (resultUserDto == null) {
				return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// 1. 아이디, 비밀번호 가져오기
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		// 2. 일을 시키기
//		try {
//			UserDto UserDto = userService.login(email);
//			if(UserDto != null && crypt.checkPw(password, UserDto.getPassword())) { // 로그인 성공
////						session 설정
//				HttpSession session = request.getSession();
//				session.setAttribute("userinfo", UserDto);
//				
////						cookie 설정
////				String idsave = request.getParameter("saveid"); // 아이디 저장 체크 여부 가져오기
////				if("ok".equals(idsave)) { // 아이디 저장을 체크 했다면.
////					Cookie cookie = new Cookie("ssafy_id", email);
////					cookie.setPath(request.getContextPath());
////					cookie.setMaxAge(60 * 60 * 24 * 365 * 40); //40년간 저장.
////					response.addCookie(cookie);
////				} else { //아이디 저장을 해제 했다면.
////					Cookie cookies[] = request.getCookies();
////					if(cookies != null) {
////						for(Cookie cookie : cookies) {
////							if("ssafy_id".equals(cookie.getName())) {
////								cookie.setMaxAge(0);
////								response.addCookie(cookie);
////								break;
////							}
////						}
////					}
////				}
//				
//				return "/index.jsp";
//			} else {
//				request.setAttribute("msg", (String)"아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
//				return "/index.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		}
//		
		return null;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "유저 리스트 반환", notes = "유저 리스트를 반환합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 리스트 반환 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> list() {
		try {
			List<UserDto> resultUserList = userService.list();
			return new ResponseEntity<List<UserDto>>(resultUserList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		// 모든 세션 정보를 제거하여 로그아웃 기능 구현
		session.invalidate();
		return "";
	}
	
	@GetMapping("/detail/{userId}")
	@ApiOperation(value = "유저 세부 정보 반환", notes = "유저 세부 정보 반환")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 세부 정보 반환 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> detail(@PathVariable("userId") String userId) {
		try {
			UserDto resultUserDto = userService.detail(userId);
			return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/leave/{userId}")
	@ApiOperation(value = "유저 탈퇴", notes = "유저가 탈퇴합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 탈퇴 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> leave(@PathVariable("userId") String userId) {
		try {
			UserDto resultUserDto = userService.leave(userId);
			return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "유저 정보 수정", notes = "유저 정보를 수정합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 정보 수정 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> update(@RequestBody UserDto userDto) {
		try {
			UserDto resultUserDto = userService.update(userDto);
			return new ResponseEntity<UserDto>(resultUserDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
}