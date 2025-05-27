package com.multitenant.repository;

import com.multitenant.entity.TeamSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamSchemaRepository extends JpaRepository<TeamSchema, Long> {
    Optional<TeamSchema> findByTeamName(String teamName);
}
