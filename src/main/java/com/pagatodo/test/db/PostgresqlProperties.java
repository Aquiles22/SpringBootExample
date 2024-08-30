package com.pagatodo.test.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.datasource.postgres")
public class PostgresqlProperties {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
}