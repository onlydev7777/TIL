package com.jpatest.domain.manytoone.repository;

import com.jpatest.domain.manytoone.Member;
import com.jpatest.domain.manytoone.TeamFlatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select new com.jpatest.domain.manytoone.TeamFlatDto(t.id, m.id, t.name, m.name) " +
            "from Member m " +
            "join m.team t " +
            "where t.id = :teamId")
    List<TeamFlatDto> findFlatDto(Long teamId);

    @Query("select new com.jpatest.domain.manytoone.TeamFlatDto(t.id, m.id, t.name, m.name) " +
            "from Member m " +
            "join m.team t " +
            "where t.name = :teamName " +
            "and m.name = :memberName")
    List<TeamFlatDto> findFlatDtoByName(String teamName, String memberName);

    @Query(value = "select new com.jpatest.domain.manytoone.TeamFlatDto(t.id, m.id, t.name, m.name) " +
            "from Member m " +
            "join m.team t " +
//            "where t.name = encrypt(:teamName, 'name') " +
//            "and m.name = encrypt(:memberName, 'name')")
            "where t.name = FUNCTION('encrypt', :teamName, 'name') " +
            "and m.name = FUNCTION('encrypt', :memberName, 'name')")
    List<TeamFlatDto> findFlatDtoByNameWithEncrypt(@Param("teamName") String teamName, @Param("memberName") String memberName);
}
