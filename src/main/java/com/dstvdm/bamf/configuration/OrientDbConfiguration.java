package com.dstvdm.bamf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.data.orient.object.repository.support.OrientObjectRepositoryFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by pscot on 3/2/2016.
 */

@Configuration
@EnableOrientRepositories(basePackages = "com.dstvdm.bamf.repository", repositoryFactoryBeanClass = OrientObjectRepositoryFactoryBean.class)
@EnableTransactionManagement
public class OrientDbConfiguration {

    @Autowired
    private OrientObjectDatabaseFactory factory;

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory = new OrientObjectDatabaseFactory();

        factory.setUrl("remote:localhost/bamf");
        factory.setUsername("admin");
        factory.setPassword("admin");

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }

    @PostConstruct
    @Transactional
    public void registerEntities() {
        factory.db().getEntityManager().registerEntityClasses("com.dstvdm.bamf.model");
    }

}