package com.alisyabob.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 시 응답(HTML파일)
//@Controller

// 사용자가 요청 시 응답(Data)을 해주는 컨트롤러
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "aaa", "1234", "a@a.com"); 
		Member m = Member.builder().username("one").password("1234").email("a@naver.com").build();
		System.out.println(TAG + "getter : " +m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : "+m.getId() );
		return "lombok test 완료";
	}
	
	/*get 방식*/
	//브라우저 요청은 get밖에 할 수 없다. get은 무조건 queryString으로 보낸다.
	//http://localhost:8080/http/get
	
	@GetMapping("/http/get")
	
	//단일
	//public String getTest(@RequestParam int id) {     
	//한번에
	public String getTest(Member m) {
		
		return "get 요청"+m.getId()+m.getUsername()+m.getEmail()+m.getPassword();
	}
	
	
	/*post 방식*/
	@PostMapping("/http/post")// application/json
	public String postTest(@RequestBody Member m) {
		return "post 요청"+m.getId()+m.getUsername()+m.getEmail()+m.getPassword();
	}
	
	
	/*put 방식*/
	//RequestBody를 통해 값을 받는다.
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
