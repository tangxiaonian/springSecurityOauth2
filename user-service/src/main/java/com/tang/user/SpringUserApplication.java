package com.tang.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringUserApplication.class, args);
    }
}
