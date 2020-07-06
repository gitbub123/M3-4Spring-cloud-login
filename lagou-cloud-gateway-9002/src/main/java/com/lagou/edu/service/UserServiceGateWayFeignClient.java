package com.lagou.edu.service;

import com.lagou.edu.service.fallback.UserServiceGateWayFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tudedong
 * @description
 * @date 2020-07-06 10:07:50
 */
@FeignClient(value = "lagou-service-user", path = "/api/user", fallback = UserServiceGateWayFeignClientFallback.class)
public interface UserServiceGateWayFeignClient {

    @GetMapping("/info/{token}")
    String info(@PathVariable("token") String token) ;
}
