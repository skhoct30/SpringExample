package com.skhoct30.spring.ex.mybatis.service;

import java.util.List;

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
	
}
