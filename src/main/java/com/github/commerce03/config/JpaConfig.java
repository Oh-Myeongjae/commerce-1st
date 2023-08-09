package com.github.commerce03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.github.commerce03.repository.post"},
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "tm"
)
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.github.commerce03.repository.post");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.format_sql", "true"); //sql 포멧 이쁘게 보기(안하면 한줄로 나옴)
        properties.put("hibernate.use_sql_comment", "true");    //SQL 볼때 주석 처리 된것두 확인하기
        properties.put("hibernate.hbm2ddl.auto","update");  //테이블 자동생성
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "tm")
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean(dataSource).getObject());
        return transactionManager;
    }
}
