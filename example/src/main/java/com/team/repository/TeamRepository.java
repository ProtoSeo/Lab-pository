package com.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
