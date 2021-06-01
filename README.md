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

------------------------------------------------------------------------

### MIME 타입이란
- (https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types)
 
------------------------------------------------------------------------

### Lombok 세팅 및 테스트
1. gitbash를 통해 lombok 실행(cmd로 해도 무관)
- @Getter, @Setter, @data, @AllArgsConstructor(모든페이지를 다쓰는 생성자), @NoArgsConstructor(빈생성자)
- @Builder를 사용하면 순서를 안지켜도됨

------------------------------------------------------------------------

### yaml 및 jsp 설정
1. yaml설정은 스프링 프로젝트 설정하는것
- 포트, 데이터베이스 연결, 인코딩 등 설정
- 기존 xml에서 yaml로 진화??
- (https://www.inflearn.com/questions/16184)

* 기존엔 root-context.xml, servlet-context로 설정을 해줬으나 SpringBoot에서는 application.yml로만 하면됨
- root-context.xml  데이터베이스 설정 (한번만 new됨 singleton으로 관리)

- servlet-context 지속적으로 new됨

* RestController는 String을 리턴 했을때  문자 그 자체를 리턴
* Controller는 해당 경로 이하의 파일을 리턴

------------------------------------------------------------------------

