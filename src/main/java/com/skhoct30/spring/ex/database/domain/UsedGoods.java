package com.skhoct30.spring.ex.database.domain;

import java.time.LocalDateTime;

// 특정 테이블의 한행의 모든 정보를 저장하기 위한 클래스 정의
// Entity class , Domain class 라고 불린다.

public class UsedGoods {
	
	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	// 날짜 시간 : LocalDateTime
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
	// 값을 저장하기 위한 게터 / 가지고 오기위한 세터
	// 저번에 썻던거로 ㄱㄱ 우클릭 > 소스 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
	
	
}
