package com.test11.demo1.config;

import org.mariadb.jdbc.Driver;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class Config {

    @Value("${db.config.url}")
    private String databaseUrl;

    @Value("${db.config.username}")
    private String databaseUser;

    @Value("${db.config.password}")
    private String databasePassword;

    @Bean
    public DataSource getDataSource() throws SQLException {
        return new MariaDbDataSource(databaseUrl + "?user=" + databaseUser + "&password=" + databasePassword);
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
