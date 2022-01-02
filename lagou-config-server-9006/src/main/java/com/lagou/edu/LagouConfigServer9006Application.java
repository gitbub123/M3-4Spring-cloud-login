package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class LagouConfigServer9006Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouConfigServer9006Application.class, args);
    }

}
