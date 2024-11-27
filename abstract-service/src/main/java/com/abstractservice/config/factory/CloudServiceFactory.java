package com.abstractservice.config.factory;

import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.DefaultMemberService;
import com.abstractservice.service.MemberService;

public class CloudServiceFactory implements ServiceFactory {
    @Override
    public MemberService createMemberService(MemberRepository memberRepository) {
        return new DefaultMemberService(memberRepository);
    }
}
