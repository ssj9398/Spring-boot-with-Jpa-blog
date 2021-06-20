package com.alisyabob.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당id는 DB에 없습니다.";
		}
		
		
		return "삭제되었습니다. id :" +id;
		
	}
	
	//save함수는 id를 전달하지 않으면 insert를 해주고
	// id를 전달하면 해당 id에 대한 데이터가 있으면 update
	//데이터가 없으면 insert 
	//email, password 수정
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		//json 데이터를 요청 => Java ObjectMessageConverter의 Jackson라이브러리가 변환해서 받아줌
		System.out.println("id :"+id);
		System.out.println("password :"+requestUser.getPassword());
		System.out.println("email :"+requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 한페이지당 2건에 데이터를 리턴받아보기
	// 페이지 별로 보려면 get방식으로 주소에 적으면 됨
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser =  userRepository.findAll(pageable);
		
		//이렇게 분기를 태울수도 있다.
		/*
		 * if(pagingUser.isLast()) {
		 * 
		 * }
		 */
		
		List<User> users = pagingUser.getContent();
		return users;
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
