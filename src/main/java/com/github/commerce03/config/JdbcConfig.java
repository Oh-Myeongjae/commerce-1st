package com.github.commerce03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("asdf1234");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/week_1?useUnicode=true&characterEncoding=UTF-8");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1() { return new JdbcTemplate(dataSource()); }

    @Bean
    public PlatformTransactionManager transactionManager() { return new DataSourceTransactionManager(dataSource()); }
}
