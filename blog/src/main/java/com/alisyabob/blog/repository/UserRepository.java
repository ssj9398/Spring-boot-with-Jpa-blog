package com.alisyabob.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alisyabob.blog.model.User;


//DAO
// 자동으로 bean등록이 되어 @Repository가 필요 없음 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
