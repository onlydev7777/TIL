package com.abstractservice.config.factory;

import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.MemberService;
import com.abstractservice.service.onpremise.SamsungMemberService;

public class SamsungServiceFactory implements ServiceFactory {
    @Override
    public MemberService createMemberService(MemberRepository memberRepository) {
        return new SamsungMemberService(memberRepository);
    }
}
