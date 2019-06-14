package com.apesing.chd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.apesing.chd.mapper")
public class ChdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChdApplication.class, args);
    }

}
