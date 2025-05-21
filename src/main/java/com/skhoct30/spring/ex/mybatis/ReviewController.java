package com.skhoct30.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.ex.mybatis.domain.Review;
import com.skhoct30.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	
	// 무조건 ResponseBody 가 아니라 여기선 이렇게 사용하는 거다 다른거도 사용할 수 있다.
	@ResponseBody
	@RequestMapping("/db/mybatis/review")
	public Review review(@RequestParam("id") int id) {
		// 전달받은 id와 일치하는 리뷰 정보를 response에 json으로 담는다~
		// 요청과 응답을 처리하는 기능      request parameter 로 전달받자.
		// review(파라미터 공간 ) spring 에서는 requestParameter 를 메소드에 어노테이션을 걸어서 사용한다 
		
		
		// 전달받은 id가 일치하는 리뷰 정보 얻어오기.
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
}
