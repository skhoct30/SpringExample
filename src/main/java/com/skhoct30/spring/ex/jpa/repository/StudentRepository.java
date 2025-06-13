package com.skhoct30.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skhoct30.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	
}
