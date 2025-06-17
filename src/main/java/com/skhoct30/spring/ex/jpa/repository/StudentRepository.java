package com.skhoct30.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skhoct30.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	// 메소드를 직접 추가하면서 해야함
	// 모든 행을 id 기반으로 내림차순 조회
	// id 기반 | 내림차순
	
	// ORDER BY `id` DESC;
	
	// By@@@@@@@ 이름 규칙을 정해줘야한다.  jpa 메소드 이름지어주는 규칙
	// 예제 문제에서는 모든 행 이라고 헀으니 일단 List 로 담자
	// By 는 조건
	public List<Student> findAllByOrderByIdDesc();
	
	
	
	// id 기반으로 내림차순 2개만 조회
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	
	// 전달 받은 이름과 일치하는 행 조회
	// WHERE `name` = #{}; << xml 에 쿼리작성할 때 사용했던 것
	// List 인 이유는 이름이 같은 것들이 여러행 (여러명 조회) 일수도 있으니까 List 에 담는다.
	public List<Student> findByName(String name); 
	
	
	// 전달 받은 이름들과 일치하는 행 조회
	// WHERE `name` = IN (#{}, #{})
	public List<Student> findByNameIn(List<String> name);
	
	
	// 전달받은 키워드가 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE '%#{}%'
	public List<Student> findByEmailContaining(String email);
	
	
	// 쿼리 직접 작성
	// 예시 : dreamJob 이 전달받은 값과 일치하는 행 조회
	// 얘는 지금까지 작성한 놈들이랑 다르다 규칙이 다름 그래서
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByQuery(@Param("dreamJob") String dreamJob);
	
	
	
	
}
