package com.skhoct30.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	
	// 직접 만든 클래스의 객채를 response에 담는 페이지
	// responseBody는 기본적으러 문자열을 담는다 근데 어케 통체로 넣어 ? 일단 클래스를 만들자 Person 으로 했음
	
	@RequestMapping("/3")
	public Person personResponse() {
		Person me = new Person("김인규", 32);
		
		return me;
	}

	
	
	// status code 수정
	// status code : servlet 에서 많이 봤지만. 우리가 요청을 하고 그 요청에 대한 응답이 철회 결과에 대한 상태를 status code 로 알려준다
	// 우리가 자주보는 404 애러? 이거는 주소를 확인을 해봐야한다. 오타도 안보이면 서버를 다시한번 껏다가 켜봐야한다. 
	@RequestMapping("/4")
	public ResponseEntity<Person> statusResponse() {
		Person me = new Person("김인규", 32);
		
		ResponseEntity<Person> entity =  new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
}
