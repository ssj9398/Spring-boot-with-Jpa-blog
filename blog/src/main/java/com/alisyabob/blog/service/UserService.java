package com.alisyabob.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alisyabob.blog.model.User;
import com.alisyabob.blog.repository.UserRepository;

//스프링이 컴포넌ㅌㅡ 스캔을 통해 Bean에 등록을 해줌. IOC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void 회원가입(User user) {
			userRepository.save(user);
	}
}