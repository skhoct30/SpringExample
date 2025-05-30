package com.skhoct30.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		
		return "ajax/ex01";
	}
	
	// response에 데이터가 담기는 페이지
	// API <-> View(html)
	
	// 이름과 생년월일을 전달 받고 이름과 나이를 응답으로 전달 한다.
	// 응답에 데이터(json)만 포함
	@ResponseBody
	@GetMapping("/ajax/person")
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2025 - year + 1;
		
		// 이름과 나이 정보만 html에 담겠다.
		// 새로고침 없이 실시간으로
		// 결과물은 항상 규격화 {"name":"김인규", "age":32} JSON문자열로 규격화해서 전달하는 것이 좋고 깔끔하다.
		
		Map<String, Object> personMap = new HashMap<>();
		
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
	}
	
}
