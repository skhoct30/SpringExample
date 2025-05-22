package com.skhoct30.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.ex.mybatis.domain.Review;
import com.skhoct30.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	
	// 무조건 ResponseBody 가 아니라 여기선 이렇게 사용하는 거다 다른거도 사용할 수 있다.
	@ResponseBody
	@RequestMapping("")
	public Review review(@RequestParam("id") int id) {
		// 전달받은 id와 일치하는 리뷰 정보를 response에 json으로 담는다~
		// 요청과 응답을 처리하는 기능      request parameter 로 전달받자.
		// review(파라미터 공간 ) spring 에서는 requestParameter 를 메소드에 어노테이션을 걸어서 사용한다 
		
		
		// 전달받은 id가 일치하는 리뷰 정보 얻어오기.
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	
	// 리뷰를 저장하는 기능
	@ResponseBody // 간단한 문자열로 웹에 보여지기 위해.
	@RequestMapping("/create")
	public String createReview() {
		// 4, 치즈피자, 서강현, 4.5, 치즈피자 존맛!
		// 이 정보를 리뷰 테이블에 저장해야한다. 근데 얘는 controller 의 역활이 아니다.
		
		//int count = reviewService.addReview(4, "치즈피자", "서강현", 4.5, "치즈피자 존맛!");

		// 실행결과 : 1
		//return "실행결과 : " + count;
		
		
		
		//2. 뿌링클, 서강현, 4.0, 역시 뿌링클은 진리입니다.
		// 얘네를 위에처럼 말고 하나로 묶고싶은데 ? 그러면 Ntity 클래스 ㄱ
		Review review = new Review();
		
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("서강현");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewService.addReviewByObject(review);
		
		return "실행결과 : " + count;
		
	}
	
	
	
}
