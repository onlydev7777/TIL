package com.abstractservice.config.factory;

import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.MemberService;

public interface ServiceFactory {
    MemberService createMemberService(MemberRepository memberRepository);
}
