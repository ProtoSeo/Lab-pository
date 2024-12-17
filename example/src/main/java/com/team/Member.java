package com.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // 기본 생성자가 필요하다.
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	protected Member() {
	}

	public Member(String username, Team team) {
		this.username = username;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Team getTeam() {
		return team;
	}
}