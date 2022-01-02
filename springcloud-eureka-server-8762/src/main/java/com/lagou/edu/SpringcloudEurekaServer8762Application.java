package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer8762Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServer8762Application.class, args);
    }

}
