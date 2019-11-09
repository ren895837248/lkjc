package com.lkjc.consumablesmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lkjc.consumablesmanager.mapper"})
public class ConsumablesManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumablesManagerApplication.class, args);
    }

}
