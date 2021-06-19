package com.alisyabob.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//{id} 주소로 파라메터를 전달 받기
	//http://localhost:8080/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//없는 값을 를 찾았을때 null이 될때 Optional로 User객체를 감싸서 가져와서 null인지 아닌지 판단해서 return
		
		//빈객체생성
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		@Override
		public IllegalArgumentException get() {
			return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
		}
	});
		return user;
	}
	
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
