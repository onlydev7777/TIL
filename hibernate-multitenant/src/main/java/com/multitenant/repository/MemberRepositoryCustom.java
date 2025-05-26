package com.multitenant.repository;

import com.multitenant.entity.Member;
import com.multitenant.entity.Team;

public interface MemberRepositoryCustom {
    Member findByNameWithTeam(Team team, String name);
}
