package com.ivaneskins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.ivaneskins")
@EnableTransactionManagement
public class HibernateConfig {

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource;
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Minsk&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.ivaneskins.model");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }

//    @Bean
//    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource());
//        emf.setPackagesToScan("com.ivaneskins.model");
//        emf.afterPropertiesSet();
//        return emf;
//    }




    //Закладка в браузере EntityManager
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceUnitName("TDPersistenceUnit");
        HibernateJpaVendorAdapter adapter =  new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setPackagesToScan("com.ivaneskins.model");
//        Properties jpaProp = new Properties();
//        jpaProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        jpaProp.put("hibernate.query.factory_class", "org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory");
//        jpaProp.put("hibernate.hbm2ddl.auto", "update");
//        jpaProp.put("hibernate.show_sql", Boolean.parseBoolean("true"));
//        jpaProp.put("hibernate.connection.charset", "UTF-8");
//        jpaProp.put("hibernate.connection.release_mode", "auto");
//        jpaProp.put("javax.persistence.validation.mode", "callback");
//        factoryBean.setJpaProperties(jpaProp);

//        Map<String, Object> jpaPropertyMap = new HashMap<>();
//        jpaPropertyMap.put("javax.persistence.validation.factory", localValidatorFactoryBean());
//        jpaPropertyMap.put("javax.persistence.validation.group.pre-persist", "com.td.model.validation.group.PrePersistGroup,javax.validation.groups.Default");
//        factoryBean.setJpaPropertyMap(jpaPropertyMap);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject() );

        return transactionManager;
    }



//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }



}
