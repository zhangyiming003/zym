package com.example.onestoponestreet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.onestoponestreet.mapper")
@EnableAsync
@EnableCaching
public class OnestoponestreetApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnestoponestreetApplication.class, args);
    }

}
