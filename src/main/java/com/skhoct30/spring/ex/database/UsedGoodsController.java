package com.skhoct30.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.ex.database.domain.UsedGoods;
import com.skhoct30.spring.ex.database.service.UsedGoodsService;


// 얘가 수행할 기능은 request, response
@Controller
public class UsedGoodsController {
	
	@Autowired // 객체를 주입해주세요.
	private UsedGoodsService usedGoodsService;

	//중고 게시글 모든 정보를 response에 담는 페이지 만들기
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// 중고 게시글의 모든 정보 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		
		return usedGoodsList;
	}
}
