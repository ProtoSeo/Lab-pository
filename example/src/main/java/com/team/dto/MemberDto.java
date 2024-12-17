package com.team.dto;

import com.team.Member;
import com.team.Team;

public class MemberDto {
	private String username;
	private Long teamId;

	public MemberDto(String username, Long teamId) {
		this.username = username;
		this.teamId = teamId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private MemberDto() {
	}

	public Long getTeamId() {
		return teamId;
	}

	public Member toMember(Team team) {
		return new Member(username, team);
	}
}
