package com.egencia.codeacademy.databases.postgresql.jpa;

import com.egencia.codeacademy.databases.postgresql.jpa.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class JPAConfiguration {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(Account.class.getPackage().getName());
//        em.setPersistenceUnitName("postgresqlDB");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//        em.setJpaVendorAdapter(vendorAdapter);
//        return em;
//    }
}
