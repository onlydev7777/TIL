package com.example.config.autoconfig;

import com.example.config.MyAutoConfiguration;
import com.example.config.MyConfigurationProperties;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

  @Bean
  public BeanPostProcessor propertyPostProcessor(Environment env) {

    return new BeanPostProcessor() {
      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName)
          throws BeansException {//1. bean 등록 후처리기 수행
        MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(),
            MyConfigurationProperties.class);//2. @MyConfigurationProperties 가 붙은 class가 대상

        if (annotation == null) {
          return bean;
        }

        Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(
            annotation);

        String prefix = (String) attrs.get("prefix");//3. @MyConfigurationProperties prefix 속성 추출

        return Binder.get(env).bindOrCreate(prefix, bean.getClass());//4. prefix Binder 처리
      }
    };
  }
}
