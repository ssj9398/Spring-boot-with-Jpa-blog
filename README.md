# Spring Boot를 이용한 블로그

## 세팅
1. jdk 1.8 설치
2. mysql 설치
3. sts툴 설치
4. github연동
5. dependencies(DevTools, Lombok, Data JPA, MySQL Driver, Security, Web) 
6. mysql 연결 및 설정
------------------------------------------------------------------------
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
    username: alisya
    password: 1q2w3e4r
```

## 시작
### httml1.1이란
#### 통신방법 4가지
1. Get
- 브라우저 요청은 get밖에 할 수 없다. get은 무조건 queryString으로 보낸다.
- 단일
```	
  public String getTest(@RequestParam int id) {  
```  
- 한번에
```
  public String postTest(@RequestBody Member m) {
```
2. Post
- body를 통해서 보낸다. form태그, json (application/json)이 대표적 
3. Put
4. Delete

* MIME 타입이란
- (https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types)





