package com.alisyabob.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alisyabob.blog.dto.ResponseDto;
import com.alisyabob.blog.model.User;

@RestController // 데이터만 리턴해줄꺼기 때문에
public class UserApiController {
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출됨");
		 return new ResponseDto<Integer>(HttpStatus.OK, 1); // 자바오브젝트를 Json으로 변환해서 리턴
	}
}
