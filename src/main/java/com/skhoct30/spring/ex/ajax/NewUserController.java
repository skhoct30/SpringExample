package com.skhoct30.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.ex.mvc.domain.User;
import com.skhoct30.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {

	// 사용자 추가 기능
	// sql 에서 new_user
	
	// mvc > service > userService
	@Autowired
	private UserService userService;
	
	
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		// 자 위에서 받아와야하는 내용들 작성.
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce); 
		
		int count = userService.addUser(user);
		
		
		// 성공했을 때, 실패했을 때 그에 대흥되는 데이터(정보) 
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		
		if(count == 1) {
			// 성공 (위에서 기능이 수행되었을 때 int count 의 값이 1이 되는거라서.)
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		
		return resultMap;
		
	}
	
	
	// 입력화면 view
	// html
	@GetMapping("/input")
	public String inputUser() {
		
		return "ajax/input";
	}
	
	
	// email을 전달 받고 중복된 email이 있는 지 확인하는 API
	@ResponseBody
	@GetMapping("/duplicate-email")
	public Map<String, Boolean> isDuplicateEmail (@RequestParam("email") String email) {
		// boolean 쓰면 안되니까 레퍼클래스 Boolean 을 쓴다
		Map<String, Boolean> resultMap = new HashMap<>();
				
		// API 니까 응답에 담아야해.
		// 중복됨  : {"isDuplicate":true} 
		// 중복안됨 : {"isDuplicate":false}
		
		if(userService.isDuplicateEmail(email)) {
			// 중복됨
			resultMap.put("isDuplicate", true);
		} else {
			// 중복안됨
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
		
	}
	
	
	
	
}
