package com.alisyabob.blog.controller.api;

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
	public ResponseDto<Integer> save(@RequestBody User user) { 
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return
		user.setRole(RoleType.USER);
		int result = userService.회원가입(user);
		 return new ResponseDto<Integer>(HttpStatus.OK, result); // 자바오브젝트를 Json으로 변환해서 리턴
	} 
}
