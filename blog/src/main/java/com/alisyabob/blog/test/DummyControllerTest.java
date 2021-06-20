package com.alisyabob.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alisyabob.blog.model.RoleType;
import com.alisyabob.blog.model.User;
import com.alisyabob.blog.repository.UserRepository;

//html파일이 아니라 data를 리턴해주는 controller = RestController
@RestController  //응답
public class DummyControllerTest {
	
	//의존성 주입 DI
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//{id} 주소로 파라메터를 전달 받기
	//http://localhost:8080/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//없는 값을 를 찾았을때 null이 될때 Optional로 User객체를 감싸서 가져와서 null인지 아닌지 판단해서 return
		
		//람다식
		/*
		 * User user = userRepository.findById(id).orElseThrow(()->{ return new
		 * IllegalArgumentException("해당 유저는 없습니다."); });
		 */
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		@Override
		public IllegalArgumentException get() {
			return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
		}
	});
		//요청 : 웹브라우저
		//user 객체 = 자바 오브젝트
		//변환 (웹브라우저가 이해할 수 있는 데이터) -> json
		//스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해 json으로 변환해서 브라우저에 던짐
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
