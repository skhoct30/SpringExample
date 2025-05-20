package com.skhoct30.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.ex.database.domain.UsedGoods;

// 데이터 베이스 관련 처리 ( query 수행 ) 
// Mybatis Framework 

// 해당하는 인터페이스에 xml과 매칭(Mapping) / xml 파일과 연결이 된다.
@Mapper
public interface UsedGoodsRepository {

	// used_goods 모든행 조회
	// 우리가 만든 Entity class >> UsedGoods
	public List<UsedGoods> selectUsedGoodsList();
	
	
}
