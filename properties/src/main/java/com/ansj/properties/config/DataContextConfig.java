package com.ansj.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
//@ConfigurationProperties(prefix="ansj.datasource")
public class DataContextConfig {
    @Value("${ansj.datasource.driverClassName}")
    String driverClassName;
    @Value("${ansj.datasource.jdbcUrl}")
    String jdbcUrl;
    @Value("${ansj.datasource.username}")
    String username;
    @Value("${ansj.datasource.password}")
    String password;
    @Bean
    public DataSource ansjDataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .username(username)
                .password(password)
                .url(jdbcUrl)
                .build();
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean ansjEntityManager(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(ansjDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.ansj.properties.entity");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }
    @Bean
    public JpaTransactionManager ansjTransactionManager(){
        return new JpaTransactionManager(Objects.requireNonNull(ansjEntityManager().getObject()));
    }
}
