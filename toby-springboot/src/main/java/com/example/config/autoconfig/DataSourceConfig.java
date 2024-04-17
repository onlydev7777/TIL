package com.example.config.autoconfig;

import com.example.config.ConditionalMyOnClass;
import com.example.config.EnableMyConfigurationProperties;
import com.example.config.MyAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
public class DataSourceConfig {

  @Bean
  @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
  @ConditionalOnMissingBean
  public DataSource hikariDataSource(MyDataSourceProperties properties) {
    HikariDataSource hikariDataSource = new HikariDataSource();

    hikariDataSource.setDriverClassName(properties.getDriverClassName());
    hikariDataSource.setJdbcUrl(properties.getUrl());
    hikariDataSource.setUsername(properties.getUsername());
    hikariDataSource.setPassword(properties.getPassword());

    return hikariDataSource;
  }

  @Bean
  @ConditionalOnMissingBean
  public DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
    SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();

    simpleDriverDataSource.setDriverClass(
        (Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
    simpleDriverDataSource.setUrl(properties.getUrl());
    simpleDriverDataSource.setUsername(properties.getUsername());
    simpleDriverDataSource.setPassword(properties.getPassword());

    return simpleDriverDataSource;
  }

  @Bean
  @ConditionalOnSingleCandidate(DataSource.class)
  @ConditionalOnMissingBean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  @ConditionalOnSingleCandidate(DataSource.class)
  @ConditionalOnMissingBean
  public JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
    return new JdbcTransactionManager(dataSource);
  }
}
