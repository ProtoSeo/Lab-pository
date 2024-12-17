package com;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.team.Team;
import com.team.repository.MemberRepository;
import com.team.repository.TeamRepository;

@SpringBootApplication
public class ExampleApplication {

	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	public ExampleApplication(MemberRepository memberRepository, TeamRepository teamRepository) {
		this.memberRepository = memberRepository;
		this.teamRepository = teamRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@PostConstruct
	public void init() {
		for (int i = 0; i < 10; i++) {

		}
		for (int i = 0; i < 100; i++) {
			teamRepository.save(new Team("team" + i));
		}
	}
}
