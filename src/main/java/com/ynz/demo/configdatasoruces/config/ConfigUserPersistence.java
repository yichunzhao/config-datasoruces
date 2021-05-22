package com.ynz.demo.configdatasoruces.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:UserPersistence.properties")
@EnableJpaRepositories(
        basePackages = {"com.ynz.demo.configdatasoruces.model.user", "com.ynz.demo.configdatasoruces.dao.user"},
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager"
)
@EnableTransactionManagement
public class ConfigUserPersistence {

    @Bean("userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.another-datasource")
    public DataSourceProperties anotherDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("userDataSource")
    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties userDataSourceProperties) {
        return userDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean("userEntityManager")
    public LocalContainerEntityManagerFactoryBean userEntityManager(@Qualifier("userDataSource") DataSource dataSource) {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("com.ynz.demo.configdatasoruces.model.user");
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(jpaVendorAdapter);

        return em;
    }

    @Bean("userTransactionManager")
    public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        return manager;
    }

}
