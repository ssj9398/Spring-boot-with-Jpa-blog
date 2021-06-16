package com.alisyabob.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //gese
@NoArgsConstructor //빈생성
@AllArgsConstructor //전체
@Builder //빌더패턴
//ORM -> Java Object -> 테이블로 매핑해주는 기술
//테이블화 시키기 위해 Entity어노테이션을 만들어줌
@Entity  //자동으로 User 클래스가 Mysql에 테이블이 생성된다.
//@DynamicInsert   //insert 시 null일 경우 제외 시켜주고 Default값이 들어감
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.(시퀀스 OR auto_increment)
	
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length =30)
	  
	private String username; //아이디
	
	@Column(nullable = false, length =100)
	private String password;
	
	@Column(nullable = false, length =50)
	private String email;
	
	//@ColumnDefault("'user'")
	//DB는 RoleType이라는게 없기때문에
	@Enumerated(EnumType.STRING)
	private RoleType role;  //Enum을 쓰는게 좋다. //권한(admin, user, manager) ADMIN, USER
	//Enum을 사용해 내가 넣으려는 값을 강제로  USER OR ADMIN으로 지정해버린다.
	@CreationTimestamp   //시간이 자동 입력
	private Timestamp createDate;
}
