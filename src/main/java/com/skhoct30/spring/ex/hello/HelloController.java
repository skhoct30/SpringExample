package com.skhoct30.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
}
