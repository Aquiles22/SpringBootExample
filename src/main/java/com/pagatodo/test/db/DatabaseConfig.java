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
@EnableConfigurationProperties({ PostgresqlProperties.class})
@EnableJpaRepositories(basePackages = "com.pagatodo.test.repository")
public class DatabaseConfig {

    @Autowired
    private PostgresqlProperties postgresqlProperties;

    @Primary
    @Bean
    public DataSourceInitializer postgresqlInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(postgresqlDataSource());
        initializer.setDatabasePopulator(
                new ResourceDatabasePopulator(new ClassPathResource("templates/schema-postgresql.sql")));
        return initializer;
    }

    @Bean
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(postgresqlProperties.getDriverClassName())
                .url(postgresqlProperties.getUrl())
                .username(postgresqlProperties.getUsername())
                .password(postgresqlProperties.getPassword())
                .build();
    }
}
