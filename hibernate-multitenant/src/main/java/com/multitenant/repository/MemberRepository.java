package com.multitenant.repository;

import com.multitenant.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByName(String name);
    @Query(value = """
        select * from members m
        where m.member_nm = :name
        limit 1
    """, nativeQuery = true)
    Member findByNameWithNative(@Param("name") String name);
}
