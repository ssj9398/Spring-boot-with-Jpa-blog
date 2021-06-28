package com.alisyabob.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alisyabob.blog.dto.ResponseDto;
import com.alisyabob.blog.model.RoleType;
import com.alisyabob.blog.model.User;
import com.alisyabob.blog.service.UserService;

@RestController // 데이터만 리턴해줄꺼기 때문에
public class UserApiController {

	@Autowired
	private UserService userService;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user, HttpSession session) {
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 Json으로 변환해서 리턴
	}
}

	
	/*  로그인은 스프링 시큐리티로 하기위해 주석
	 * @PostMapping("/api/user/login") 
	 * public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
	 * System.out.println("UserApiController : login 호출됨"); 
	 * User principal = userService.로그인(user);  // principal (접근주체)
	 * if(principal!=null) { 
	 * session.setAttribute("principal", principal); 
	 * } 
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */

