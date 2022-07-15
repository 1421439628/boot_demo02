package com.atguigu.boot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class BootDemo02Application {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootDemo02Application.class, args);
        JdbcTemplate bean = run.getBean(JdbcTemplate.class);
        System.out.println(bean);
        System.out.println("master");
        System.out.println("hot-fix");
        System.out.println("change 23:26");
        System.out.println("change from github");
    }

}
