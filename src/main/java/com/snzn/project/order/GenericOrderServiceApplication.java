package com.snzn.project.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GenericOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericOrderServiceApplication.class, args);
    }

}
