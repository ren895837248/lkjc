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

    /*double rate = 0.5;
    double density = 1.33;
    double densityWater = 1;

    public double test(double t,double densityC){
        double x = ((densityC * rate * t)/density - rate * t) /(1.0 - densityC/densityWater);
        return x + t + rate *t;
    }

    public static void main(String[] args) {
        DataSourceConf dataSourceConf = new DataSourceConf();
        System.out.println(dataSourceConf.test(1000,1.2));
    }*/


}
