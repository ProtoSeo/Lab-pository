package com.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
