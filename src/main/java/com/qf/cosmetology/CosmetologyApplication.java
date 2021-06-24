package com.qf.cosmetology;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.qf.cosmetology.dao") //将dao层的接口添加到容器，让其扫描
public class CosmetologyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CosmetologyApplication.class, args);
    }

}
