package com.cafe24.mapping.m2o_uni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="Team_id")
	private Team team;

}
