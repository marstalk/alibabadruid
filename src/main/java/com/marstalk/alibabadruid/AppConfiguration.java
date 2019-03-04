package com.marstalk.alibabadruid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource alibabaDruid() {
        return new DruidDataSource();
    }
}
