package com.team.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.Member;
import com.team.Team;
import com.team.dto.MemberDto;
import com.team.repository.MemberRepository;
import com.team.repository.TeamRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
		this.memberRepository = memberRepository;
		this.teamRepository = teamRepository;
	}

	@Transactional
	public Long saveMember(MemberDto memberDto) {
		Team team = teamRepository.findById(memberDto.getTeamId()).orElseThrow(IllegalArgumentException::new);
		Member member = memberRepository.save(memberDto.toMember(team));
		return member.getId();
	}
}
