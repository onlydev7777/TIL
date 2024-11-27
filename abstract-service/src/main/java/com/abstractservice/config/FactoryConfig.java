package com.abstractservice.config;

import com.abstractservice.config.factory.CloudServiceFactory;
import com.abstractservice.config.factory.HyundaiServiceFactory;
import com.abstractservice.config.factory.SamsungServiceFactory;
import com.abstractservice.config.factory.ServiceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ProductionProperties.class)
@Configuration
public class FactoryConfig {
//    @RefreshScope
    @Bean
    public ServiceFactory serviceFactory(ProductionProperties properties) {
        Production production = properties.getProduction();

        if (production == Production.Hyundai) {
            return new HyundaiServiceFactory();
        } else if (production == Production.Samsung) {
            return new SamsungServiceFactory();
        }

        return new CloudServiceFactory();
    }
}
