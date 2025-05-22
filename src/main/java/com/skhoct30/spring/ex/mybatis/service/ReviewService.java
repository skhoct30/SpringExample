package com.skhoct30.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.ex.mybatis.domain.Review;
import com.skhoct30.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달받은 id와 일치한느 리뷰 정보 얻어오기
	public Review getReview(int id) {
		
		// new_review 테이블에서 전달 받은 id와 일치하는 행 조회
		// Natity 클래스(review) 로 리턴했음.
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
	// sellerId, 메뉴, ㅏ작성자, 별점, 리뷰 를 전달받아 저장하는 기능
	
	public int addReview(int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		
		//여기선 행의 개수라서 int count 라고 함
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	// Review  객체를 통해 리뷰 정보를 저장하는 기능
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;
	}
	
	
	
}
