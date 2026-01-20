package com.sist.web.vo;

import java.sql.Date;

import lombok.Data;
/*
 * 	NO         NOT NULL NUMBER       
	CNO                 NUMBER       
	TYPE                NUMBER       
	ID                  VARCHAR2(20) 
	NAME       NOT NULL VARCHAR2(51) 
	SEX                 VARCHAR2(6)  
	MAG        NOT NULL CLOB         
	REGDATE             DATE         
	GROUP_ID            NUMBER       
	GROUP_STEP          NUMBER       
	GROUP_TAB           NUMBER       
	ROOT                NUMBER       
	DEPTH               NUMBER   
 */
/*
 * 	1. Spring 기반 => 애플리케이션을 빠르고 쉽게 개발을 하기 위한 프레임워크
 *     ** SpringFramework        Spring-Boot
 *     ---------------------------------------
 *         XML / Java 설정			자동 설정
 *         외부 tomcat 사용			내장 톰캣
 *         시작 : 복잡					속도 빠름
 *     ---------------------------------------
 *     src/main/java => 자바 클래스
 *     		 |
 *     src/main/resource => image/css/js
 *     	     |
 *     => ThymeLeaf 중심 => 보조 : JSP
 *     => 전자정부 프레임워크 : Srping 5 => SpringFramework 기반
 *     ---------------------------------------------------
 *     SpringFramework : XML + Annotation
 *     Spring-Boot : Annotation
 *     1. 구동 : Kotlin
 *     	  @SpringBootApplication => main
 *     2. 메모리 할당
 *     	  @Component / @Repository / @Service
 *        @Controller / @RestController
 *     3. DI : 객체 주입
 *        @Autowired => @RequiredArgsConstructor
 *        			 => 생성자 만들고, 생성자에서 주입
 *     4. 웹 구동
 *     	  @GetMapping / @PostMapping / @RequestMapping
 *        => 값을 받는 경우
 *        	 @RequestParam
 *           @ModelAttribute
 *           @RequestBody => JSON => 객체
 *           @PathVariable
 *           ------------- React
 *           			   | MySQL / JPA / PathVariable
 *           				--------------------------- JWT 인증
 *     5. MVC 구조
 *        User === Controller === Service === Mapper === DB
 *        									  ------ Repository
 *     6. ORM
 *        = MyBatis => CRUD / 동적 쿼리
 *        = JPA => CRUD (SQL, 메소드 규칙)
 *     ------------------------------------------------------------
 *     Security
 *       => Session / Cookie(JWT) : 인증/인가
 *     WebSocket
 *     	 => SockJS / Stomp
 *     
 *     FileUpload / FileDownLoad
 *     Test : Junit => 단위 테스트
 *     기타 : Spring AI / Kafka / Task(Batch)
 *     ------------------------------------------------------------
 *     Front-End
 *      - JQuery : Ajax
 *      - VueJS : Pinia
 *      - React : tanStack-Query
 *      - NodeJS / TypeScript
 *      ------------------------- HTML / CSS / JavaScript
 *      
 *     Docker / Docker-Compose
 *     => 애플리케이션과 실행 ㅗ한경을 저장 => 필요하게 실행하는 플랫폼
 *     => image 화 시켜젓 저장
 */
@Data
public class CommonsCommentVO {
	private int no,cno,type,group_id,group_step,group_tab,root,depth;
	private String id,name,sex,msg;
	private Date regdate;
}
