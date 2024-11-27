package com.abstractservice.config;

import com.abstractservice.config.factory.ServiceFactory;
import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.MemberService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ProductionProperties.class)
@Configuration
public class ProductionConfig {
    private final ServiceFactory serviceFactory;

    public ProductionConfig(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository){
        return serviceFactory.createMemberService(memberRepository);
    }
}
