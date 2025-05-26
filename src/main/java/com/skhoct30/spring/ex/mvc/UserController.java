package com.skhoct30.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skhoct30.spring.ex.mvc.domain.User;
import com.skhoct30.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	// 가장 최근에 등록한 사용자 정보를 html 로 response 에 담는다
	// 사용자 1명
	@RequestMapping("/info")
	public String userInfo(Model model) {
		// 가장 최근에 등록한 사용자 정보
		User user = userService.getLastUser();
		
		//                    키         벨류
		model.addAttribute("title", "가장 최근 등록 사용자");
		model.addAttribute("result", user);
		
		// User 객체를 html 에서 활용을 해야하는데 중간 지점이(양말) 이 필요하다 그게 Model
		// responseBody 쓰지말고 경로를 리턴하면됨.
		return "mvc/userInfo";
		
	}
	
	@PostMapping("/create")
	public String createUser(
			 @RequestParam("name") String name
			 ,@RequestParam("birthday") String birthday
			 ,@RequestParam("email") String email
			 ,@RequestParam(value="introduce", required=false) String introduce
			 , Model model) {
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userService.addUser(user);
		
		model.addAttribute("title", "가장 최근 등록 사용자");
		model.addAttribute("result", user);		
		
		
		return "mvc/userInfo";
	 }
	
	@GetMapping("/input")
	public String userInput() {
		
		return "mvc/userinput";
	}

}
