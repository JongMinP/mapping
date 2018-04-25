package com.cafe24.mapping.m2m.uni.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long id;

	private String name;

	// 역방향 추가
	@ManyToMany(mappedBy = "products")
	private List<Member> members = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public Product setId(Long id) {
		this.id = id;

		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;

		return this;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
