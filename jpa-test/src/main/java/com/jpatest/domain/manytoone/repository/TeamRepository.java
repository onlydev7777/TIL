package com.jpatest.domain.manytoone.repository;

import com.jpatest.domain.manytoone.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
