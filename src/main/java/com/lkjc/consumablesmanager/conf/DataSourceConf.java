package com.lkjc.consumablesmanager.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {


    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://115.28.184.185:3306/lkjc");
        dataSource.setUsername("lkjc");
        dataSource.setPassword("lkjc123");
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(10);
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }


}
