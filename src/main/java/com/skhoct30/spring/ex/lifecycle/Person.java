package com.skhoct30.spring.ex.lifecycle;



public class Person {

	// 1. 멤버변수를 무엇으로 할지 ?
	// 이름 , 나이
	private String name;
	private int age;
	
	
	
	
	// 2. 해당하는 멤버변수를 채우기 위한 방법을 만들자
	// 생성자를 통해서 채우자.
	public Person(String name, int age) {
		this.name = name;
		this.age = age;	
	}
	
	
	
	
	// 겟터 
	// private 이 여기 안에서만 사용할 수 있는 거라서 얘를 겟터로 변환해서 내보내줘야함.
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	// 3. toString 을 override 해주셈
	@Override
	public String toString() {
		return "이름 : " + name + "나이 : " + age;
	}
	
}
