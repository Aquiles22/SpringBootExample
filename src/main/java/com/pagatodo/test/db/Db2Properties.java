package com.pagatodo.test.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class Db2Properties {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
}
