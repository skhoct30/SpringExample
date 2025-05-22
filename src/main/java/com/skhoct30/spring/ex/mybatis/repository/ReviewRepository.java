package com.skhoct30.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// new_review 테이블에서 전달 받은 id와 일치하는 행 조회 
	public Review selectReview(@Param("id")int id);
	
	// sellerId, menu, userName, point, review 를 한행 저장하는 기능
	// 리턴 타입은 int 왜? 개수를 나타내기 위해서 
	// 정해진 행의 개수를 전달 받아야하니까 int
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	
	// Review 객체를 통해 한행을 저장하는 기능
	// Review 객체 안에서는 insert쿼리를 수행할 놈들이 다 있음.
	public int insertReviewByObject(Review review);
	
}
