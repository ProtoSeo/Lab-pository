package com.team.dto;

public class MemberRequest {
	private String username;
	private Long teamId;

	public MemberRequest(String username, Long teamId) {
		this.username = username;
		this.teamId = teamId;
	}

	protected MemberRequest() {
	}

	public MemberDto toMemberDto() {
		return new MemberDto(username, teamId);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
