package com.cafe24.mapping.m2m.uni.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name="MEMBER_PRODUCT", joinColumns = @JoinColumn(name="MEMBER_ID"),
									  inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
	private List<Product> products = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public Member setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

}
