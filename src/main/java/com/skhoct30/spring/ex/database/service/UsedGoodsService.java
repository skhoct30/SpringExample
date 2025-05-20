package com.skhoct30.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.ex.database.domain.UsedGoods;
import com.skhoct30.spring.ex.database.repository.UsedGoodsRepository;

// 로직 담당(business)
// 데이터 가공
// 그 외 복잡한 기능 수행
@Service
public class UsedGoodsService {
	
	// 의존성을 주입하기 위해서. 사용한다.  -  DI
	// 객체 생성을 Spring Framework 에서 직접 관리
	@Autowired 
	private UsedGoodsRepository usedGoodsRepository;
	
	
	// 중고 게시글 정보 모두 얻어오기
	public List<UsedGoods> getUsedGoodsList() {
		// used_goods 테이블 모든 행 조회
		// 쿼리를 이제 수행해야한다.
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
		
	}
	
}
