package com.multitenant.repository;

import com.multitenant.entity.Member;
import com.multitenant.entity.Team;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.multitenant.entity.QMember.*;
import static com.multitenant.entity.QTeam.*;

public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public Member findByNameWithTeam(Team pTeam, String name) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if(pTeam != null) {
            whereBuilder.and(team.eq(pTeam));
        }
        return queryFactory.selectFrom(member)
                .leftJoin(member.team, team).fetchJoin()
                .where(
                        member.name.eq(name),
                        whereBuilder
                )
                .fetchOne();
    }
}
