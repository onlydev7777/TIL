package com.abstractservice.service.strategy;

import com.abstractservice.entity.Member;

public interface MemberStrategy {

  Member findById(Long id);
}
