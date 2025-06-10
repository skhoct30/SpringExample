package com.skhoct30.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	
	
	public User selectLastUser();
	
	public int insertUser(User user);
	
	// 전달 받은 email 이 포험된 행의 개수 조회
	
	public int selectCountByEmail(@Param("email") String email);
	
	
}
