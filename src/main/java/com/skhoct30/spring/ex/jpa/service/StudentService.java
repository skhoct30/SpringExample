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
		
		// 원하는 컬럼에만 지정해서 값을 넣는다. builder패턴
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
	
	public Student updateStudent(int id, String dreamJob) {
		
		// 몇단계를 거처서 진행된다
		
		// primary 키로 수정대상 조회해야함
		
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
		
		// null 이 아니다 기다 아니다 true false
		if(optionalStudent.isPresent()) {
			// null 이 아니다 \ 업데이트를 수행해야한다.
			Student student = optionalStudent.get(); // get 하면 알맹이를 꺼내서 확인할 수 있다.
			
			// 특정멤버변수 수정 \ 캡슐화했는데 setter 쓰면 좋지않다. \ 객체를 수정하는데 toBuilder
			student = student.toBuilder().dreamJob(dreamJob).build(); // dreamJob 수정하는 법
			// student 에는 dreamJob이 수정된 값이 저장되어 있다
			
			// student 를 넣었는데 위에랑 똑같아도 여기에서는 findById 로 인해 id값이 지정되어 있어서 여기서는 어 나는 dreanJob을 수정한 값이 있어. 그래서 지정하는 곳에 수정값을 넣음
			Student result = studentRepository.save(student); // 이거 ? 가로 안에 Entity 클래스를 넣어서 위에 저장하는 기능처럼 똑같이 사용한다
			
			return result;
			
		} else {
			// null 이다
			return null;
			
		}

	}
	
	
	
	// 삭제기능
	public void deleteStudent(int id) {
		// 삭제 대상 행을 조회 한다.
		// 조회된 행을 삭제 한다.
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		if(optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			studentRepository.delete(student);
			// 얘는 delete 라서 void 로 정하고 리턴값은 없다. 삭제만 하는 기능이라서 보여지는게 없음 . 
		}
	}
	
	
	
	
	
}
