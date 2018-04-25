package com.cafe24.mapping.m2o_by.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public void setTeam(Team team) {
		this.team = team;

		// 무한 루프에 빠지지 않도록 체크
		if (team.getMembers().contains(this) == false) {
			team.getMembers().add(this);
		}

	}

	public Long getId
	() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", team=" + team + "]";
	}

}
