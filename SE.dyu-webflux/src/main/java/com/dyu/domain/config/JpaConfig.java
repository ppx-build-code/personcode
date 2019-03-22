package com.dyu.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author dyu
 * @date 2019/03/23
 */
@Configuration
public class JpaConfig {

    @Resource
    private DataSource dataSource;

    //public EntityManagerFactory entityManagerFactory() {
    //    LocalContainerEntityManagerFactoryBean
    //}
}
