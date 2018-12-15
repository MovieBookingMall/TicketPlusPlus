package com.lbc.ticketplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lbc.ticketplus.dao") // mybatis扫描路径，针对的是接口Mapper类
public class TicketplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketplusApplication.class, args);
        System.out.println("program running");
    }
}


