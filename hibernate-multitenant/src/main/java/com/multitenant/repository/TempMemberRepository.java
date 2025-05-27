package com.multitenant.repository;

import com.multitenant.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TempMemberRepository extends JpaRepository<TempMember, Long> {
    Optional<TempMember> findByTeamNameAndName(String teamName, String name);

    List<TempMember> findAllByTeamName(String teamName);
}
