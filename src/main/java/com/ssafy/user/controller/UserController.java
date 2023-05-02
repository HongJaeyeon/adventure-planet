package com.ssafy.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;
import com.ssafy.util.Crypt;

@RestController
@RequestMapping("/user")
public class UserController {
	
//	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	private Crypt crypt;

	public UserController(UserService userService, Crypt crypt) {
		super();
		this.userService = userService;
		this.crypt = crypt;
	}
	
	@PostMapping("/regist")
	public ResponseEntity<?> regist(@RequestBody Map<String, String> param) throws IOException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", param.get("member_id"));
			map.put("userEmail", param.get("member_email"));
			map.put("userPassword", param.get("member_password"));
			map.put("userName", param.get("member_name"));
			UserDto userDto = userService.regist(map);
			
//			UserDto userDto = new UserDto();
//			userDto.setUserId(param.get("member_id"));
//			userDto.setUserEmail(param.get("member_email"));
//			userDto.setUserPassword(param.get("member_password"));
//			userDto.setUserName(param.get("member_name"));
			
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		// 모든 세션 정보를 제거하여 로그아웃 기능 구현
		session.invalidate();
		return "";
	}
	
	private String leave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDto UserDto=(UserDto)session.getAttribute("userinfo");
		
		boolean quit=false;
		try {
			quit = userService.delete(UserDto);
		} catch (SQLException e) {
		}
		
		if(quit)
			request.setAttribute("msg",(String)"정상적으로 탈퇴되었습니다.");
		else
			request.setAttribute("msg",(String)"회원탈퇴에 실패하였습니다.");
		return "/index.jsp";
	}
	
}