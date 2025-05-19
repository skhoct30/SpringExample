package com.skhoct30.spring.ex.database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhoct30.spring.ex.database.service.UsedGoodsService;


// 얘가 수행할 기능은 request, response
@Controller
public class UsedGoodsController {
	
	//중고 게시글 모든 정보를 response에 담는 페이지 만들기
	
	@RequestMapping("/db/usedgoods/list5")
	public  usedGoodsList() {
		
		UsedGoodsService usedGoodsService = new UsedGoodsService();
		usedGoodsService.getUsedGoodsList();
		
	}
}
