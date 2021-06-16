package com.alisyabob.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alisyabob.blog.model.RoleType;
import com.alisyabob.blog.model.User;
import com.alisyabob.blog.repository.UserRepository;

@RestController  //응답
public class DummyControllerTest {
	
	//의존성 주입 DI
	@Autowired
	private UserRepository userRepository;
	
	//http://localhost:8080/blog/dummy/join(요청)
	//http의 body에 username, password, email 데이터를 가지고(요청)
	@PostMapping("/dummy/join")  //insert할꺼기 때문
	public String join(User user) { //key = value
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}

}
