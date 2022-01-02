package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LagouServiceUser8080Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouServiceUser8080Application.class, args);
    }

}
