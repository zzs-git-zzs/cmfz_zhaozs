package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")//创建dao实现类对象
public class CmfzZhaozsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CmfzZhaozsApplication.class, args);
    }

}
