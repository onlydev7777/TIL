package com.abstractservice.config.factory;

import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.MemberService;
import com.abstractservice.service.onpremise.HyundaiMemberService;

public class HyundaiServiceFactory implements ServiceFactory {
    @Override
    public MemberService createMemberService(MemberRepository memberRepository) {
        return new HyundaiMemberService(memberRepository);
    }
}
