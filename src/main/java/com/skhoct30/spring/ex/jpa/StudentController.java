package com.skhoct30.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.ex.jpa.domain.Student;
import com.skhoct30.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// 저장기능
	@ResponseBody
	@GetMapping("/create")
	
	public Student createStudent() {
		
		Student student =  studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		
		return student;
	}
	
	// 수정기능
	// api에 넣어야하니 똑같이
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id 가 2인 학생 장래 희망을 강사로 변경
		Student student = studentService.updateStudent(2, "강사");
		
		return student;
	}
	
	
	
	// 삭제기능
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 2인 학생 정보
		
		studentService.deleteStudent(2);
		
		return "삭제성공";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// 입력확인 기능
	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		
		// Student student = new Student();
		// 위에 내용이 안되는 건 @AllArgsConstructor 이걸 써서 생성자가 만들어져 있음 Ntity클래스에
		// 그러므로
//		Student student = new Student(4, "김인규", "010-1234-5678", "lecture@hagulu.com", "프로그래머", LocalDateTime.now(), LocalDateTime.now());
//		student.setDreamJob("강사");
		
		
		// builder 패턴
		// builder().멤버변수 이름(저장하고 싶은 내용).멤버변수 이름(저장내용)
		Student student = Student.builder()
				.name("유재석")
				.dreamJob("개그맨")
				.phoneNumber("010-1111-2222")
				.build();
		
		
		
		return student;
		
		
	}
	
	
	
}
