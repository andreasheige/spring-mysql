package com.toto.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@ComponentScan("com.todo")
public class TodoConfig {
    
    private DataSource dataSource;

    public TodoConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "com.todo" });

        return sessionFactory;
    }
}