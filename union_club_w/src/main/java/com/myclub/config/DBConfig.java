package com.myclub.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = {"com.myclub.repositories"})
// @EnableJpaAuditing(auditorAwareRef = "")
// @EnableJpaAuditing 는 Entity에 있어서 기본적으로 포함되는 createdAt, modifiedAt, createdBy, modifiedBy등을 자동으로 주입시킬 수있도록 해주는 설정이다.
public class DBConfig {
    

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String databaseUser;
    @Value("${spring.datasource.password}")
    private String password;


    // @Bean
    // public DataSource dataSource() {
    //     DataSource dataSource = new DataSource();
    //     dataSource.setDriverClassName("org.h2.Driver");
    //     dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
    //     dataSource.setUsername("sa");
    //     dataSource.setPassword("sa");
    //     return dataSource;
    // }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
        dataSource.setDriverClassName(databaseDriverClassName);
        dataSource.setUrl(databaseUrl); 
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(password);
        
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties(){
        Properties hibernateProp=new Properties();
        // hibernateProp.put("hibernate.dialect", )
        hibernateProp.setProperty("hibernate.hbm2ddl.auto", "none"); // create-drop
        hibernateProp.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        return hibernateProp;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
 
        return transactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.myclub.entities");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }




}