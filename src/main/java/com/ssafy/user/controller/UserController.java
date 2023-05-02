package com.ssafy.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.util.Crypt;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

public class UserController {
	
	private static final long serialVersionUID = 1L;
    
	private MemberService memberService;
	private Crypt crypt;
	
    public void init() {
    	memberService = MemberServiceImpl.getInstance();
    	crypt = Crypt.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		process(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		
		String path = "";
		switch (action) {
		case "regist":
			path = regist(request, response);
			forward(request, response, path);
			break;
		case "emailcheck":
			redirect(request, response, path);
		case "login":
			path = login(request, response);
			forward(request, response, path);
			break;
		case "logout":
			path = logout(request, response);
			redirect(request, response, path);
			break;
		case "leave":
			path = leave(request, response);
			forward(request, response, path);
			break;
		default:
			break;
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		try {
			Member member = new Member();
			member.setEmail(request.getParameter("regist-email"));
			member.setNickname(request.getParameter("nickname"));
			member.setPassword(crypt.encryptPw(request.getParameter("regist-password")));
			
			if(!request.getParameter("regist-password").equals(request.getParameter("regist-password-con"))) {
				request.setAttribute("msg",(String)"비밀번호와 비밀번호 확인이 다릅니다.");
				return "/index.jsp";
			}
			
			memberService.regist(member);
			
			return "/index.jsp";
		} catch (Exception e) {
			request.setAttribute("msg",(String)"회원가입 실패");
			e.printStackTrace();
			return "/index.jsp";
		}
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 아이디, 비밀번호 가져오기
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// 2. 일을 시키기
		try {
			Member member = memberService.login(email);
			if(member != null && crypt.checkPw(password, member.getPassword())) { // 로그인 성공
//						session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", member);
				
//						cookie 설정
//				String idsave = request.getParameter("saveid"); // 아이디 저장 체크 여부 가져오기
//				if("ok".equals(idsave)) { // 아이디 저장을 체크 했다면.
//					Cookie cookie = new Cookie("ssafy_id", email);
//					cookie.setPath(request.getContextPath());
//					cookie.setMaxAge(60 * 60 * 24 * 365 * 40); //40년간 저장.
//					response.addCookie(cookie);
//				} else { //아이디 저장을 해제 했다면.
//					Cookie cookies[] = request.getCookies();
//					if(cookies != null) {
//						for(Cookie cookie : cookies) {
//							if("ssafy_id".equals(cookie.getName())) {
//								cookie.setMaxAge(0);
//								response.addCookie(cookie);
//								break;
//							}
//						}
//					}
//				}
				
				return "/index.jsp";
			} else {
				request.setAttribute("msg", (String)"아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return "/index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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
		Member member=(Member)session.getAttribute("userinfo");
		
		boolean quit=false;
		try {
			quit = memberService.delete(member);
		} catch (SQLException e) {
		}
		
		if(quit)
			request.setAttribute("msg",(String)"정상적으로 탈퇴되었습니다.");
		else
			request.setAttribute("msg",(String)"회원탈퇴에 실패하였습니다.");
		return "/index.jsp";
	}
	
}