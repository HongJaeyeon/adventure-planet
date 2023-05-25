package com.ssafy.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.jwt.model.service.JwtService;
import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;
import com.ssafy.util.Crypt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(tags = {"유저 API"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
//	private static final long serialVersionUID = 1L;
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
    
	private UserService userService;
	private Crypt crypt;
	private JwtService jwtService;

	public UserController(UserService userService, Crypt crypt, JwtService jwtService) {
		super();
		this.userService = userService;
		this.crypt = crypt;
		this.jwtService = jwtService;
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
			userDto.setUserPassword(crypt.encryptPw(userDto.getUserPassword()));
			userService.regist(userDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "유저 로그인", notes = "유저가 로그인합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "유저 로그인 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if (loginUser != null && crypt.checkPw(userDto.getUserPassword(), loginUser.getUserPassword())) {
				String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId());// key, data
				userService.saveRefreshToken(userDto.getUserId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		System.out.println(request.getHeader("access-token"));
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.userInfo(userid);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("messag"
						+ "e", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
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
	
	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable("userId") String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
	
	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, userDto);
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userid", userDto.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
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