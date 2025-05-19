package com.skhoct30.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	
	@RequestMapping("/lifecycle/ex02")
	public String thyemleafResponse() {
		
		// 응답에 대한 html 파일 경로 리턴
		
		// src/main/resources/templates 생략.
		// 파일 확장자는 .html 을 쓰는데 이것도 생략 가능.
		// 이거 다 속성을 잡아놔서 가능함
		
		return "lifecycle/ex02";
	}
	
	
	
}
