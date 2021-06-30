package com.alisyabob.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alisyabob.blog.model.User;


//DAO
// 자동으로 bean등록이 되어 @Repository가 필요 없음 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}


// JPA Naming 쿼리
// findByUsernameAndPassword
//select * from user where username=? and password =? 가 동작한다.
//User findByUsernameAndPassword(String username, String password);

/* 방법 2(native쿼리)    UserRepository.login을 호출하면 아래 쿼리가 돌아 리턴을 User객체로 해준다.
 * @Query(value ="select * from user where username=? and password =?", nativeQuery = ture) 
  User login(String username, String password);*/