# Spring Boot를 이용한 블로그

1. jdk 1.8 설치
2. mysql 설치
3. sts툴 설치
4. github연동
5. dependencies(DevTools, Lombok, Data JPA, MySQL Driver, Security, Web) 
6. mysql 연결 및 설정
'''
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
    username: alisya
    password: 1q2w3e4r
'''
