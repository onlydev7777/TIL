package com.multitenant.repository;

import com.multitenant.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = """
        select * from team t
        where t.team_nm = :name
        limit 1
    """, nativeQuery = true)
    Optional<Team> findByNameWithNative(@Param("name") String name);

    Optional<Team> findByName(@Param("name") String name);
}
