package com.skhoct30.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.ex.mvc.domain.User;
import com.skhoct30.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	// 가장 최근에 등록한 사용자 정보 얻어오기
	public User getLastUser() {
		
		User user = userRepository.selectLastUser();
		
		return user;
		
	}
	
	
	// create
	// 정보 전달받고 사용하는 기능
	
	public int addUser(User user) {
		
		int count = userRepository.insertUser(user);
		
		return count;
		
		
	}
	
	
	
	
	
	
	// ajxa 추가 내용
	// 전달 받은 ㄴㄴㄴemail 이 중복된 것인지 판별
	
	// boolean = true false 기다 아니다 / 확실명확한거라서 boolean 선택
	public boolean isDuplicateEmail(String email) {
		
		// 중복이 됐다 안됐다 처리해본 적은 없는데...
		
		// 조회된 행의 개수
		int count = userRepository.selectCountByEmail(email);
		
		//조건문으로 해야함
		if(count == 0) {
			// 중복안됨
			return false;
		} else {
			// 중복됨
			return true;
		}
		
	}
	
	
	
}
