package com.pagatodo.test.db;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


@Configuration
@EnableConfigurationProperties({ PostgresqlProperties.class, Db2Properties.class })
@EnableJpaRepositories(basePackages = "com.pagatodo.test.repository")
public class DatabaseConfig {

    @Autowired
    private PostgresqlProperties postgresqlProperties;

    //@Autowired
    //private Db2Properties db2Properties;

    @Primary
    @Bean
    public DataSourceInitializer postgresqlInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(postgresqlDataSource());
        initializer.setDatabasePopulator(
                new ResourceDatabasePopulator(new ClassPathResource("templates/schema-postgresql.sql")));
        return initializer;
    }

    /*@Bean
    public DataSourceInitializer db2Initializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(db2DataSource());
        initializer
                .setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("templates/schema-db2.sql")));
        return initializer;
    }*/

    @Bean
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(postgresqlProperties.getDriverClassName())
                .url(postgresqlProperties.getUrl())
                .username(postgresqlProperties.getUsername())
                .password(postgresqlProperties.getPassword())
                .build();
    }

    /*@Bean
    public DataSource db2DataSource() {
        return DataSourceBuilder.create()
                .driverClassName(db2Properties.getDriverClassName())
                .url(db2Properties.getUrl())
                .username(db2Properties.getUsername())
                .password(db2Properties.getPassword())
                .build();
    }*/

    /*@Bean
    public PlatformTransactionManager transactionManager() {
        return new JtaTransactionManager();
    }*/

    /*@Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresqlDataSource());
        em.setDataSource(db2DataSource());
        em.setPackagesToScan("com.pagatodo.test.dao");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPersistenceUnitName("mi-persistencia-unit");
        //Properties props = new Properties();
        //props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        //props.put("hibernate.dialect", "com.ibm.db2.jcc.DB2Dialect");
        //em.setJpaProperties(props);
        return em;
    }*/
}
