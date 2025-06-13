package com.skhoct30.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.ex.jpa.domain.Student;
import com.skhoct30.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {

	
	
	@Autowired
	private StudentRepository studentRepository;
	
	// 저장기능
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		
		Student student = Student.builder()
		.name(name)
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob)
		.build();
		
		Student result = studentRepository.save(student);
		
		return result;
		
	}
	
	
	// 수정기능
	
	public updateStudent(int id, String dreamJob) {
		
		// 몇단계를 거처서 진행된다
		
		// 수정대상의 행 조회
		// 조회 결과 객체 얻어 오기 Entity class로/
		// 객체에 수정사항 적용
		// 수정된 객체를 저장
		
		// 조회 대상의 프라이머리 키 (id) 를 얻어와 리턴해줌.
		// optional : null 일수도 있는 객체를 감싸놓은 클래스 \ 알맹이가 있는데 껌대기를 감싸고 있다. 근데 그 안에 있는 내용이 null일 수도 있다.
		// null 처리에 필요한 기능들을 포함시켜놨다. \ 기능들을 제공하는 클래스 \ null 을 통해서 발생될 수 있는 치명적인 문제(NullPointException)를 줄이기 위한 용도
		// null일 수도 있는 객체를 return 하는 메소드에서 return type 으로 활용
		// (내가 리턴할 객체가 널일 수도 있으니 좀 신경써서 처리해줘라)
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// null 이 아니다 기다 아니다
		// true false
		if(optionalStudent.isPresent()) {
			// null 이 아니다
			Student student = optionalStudent.get(); // get 하면 알맹이를 꺼내서 확인할 수 있다.
		} else {
			// null 이다
		}
		
		
		
		
		
		
	}
	
}
