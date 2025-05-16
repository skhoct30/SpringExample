package com.skhoct30.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {

	
	// 간단한 html을 response  담는 페이지
	// 응답을 어떻게 만드냐에 따라서 리턴타입이 잡히는데
	// 해당하는 문자열을 ResponseBody 에 넣어준다 어떤걸 ? String 으로 지정타입한걸.
	
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/1")
	public String htmlResponse() {
		
		return ""
				+ "<html>\n"
				+"		<head><title>Sprint</title></head>\n"
				+ "		<body>\n"
				+ "			<h2>Spring html response</h2>\n"
				+ "		</body>\n"
				+ "</html>";
	}
	
	
	
	
	
	// 맵을 response 에 담는 페이지
	
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/2")
	public Map<String, Integer> mapResponse() {
		
		// 어떤 타입의 맵인지
		// 과일이름 : 가격
		// 키 : 벨류 
		
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 4500);
		fruitMap.put("orange", 1300);
		
		
		
		return fruitMap;
	}
	
	
	
	
	
	
	
	
	
}
