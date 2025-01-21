package com.listener.map.repository;

import com.listener.map.entity.MemberMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMapRepository extends JpaRepository<MemberMap, Long> {
}
