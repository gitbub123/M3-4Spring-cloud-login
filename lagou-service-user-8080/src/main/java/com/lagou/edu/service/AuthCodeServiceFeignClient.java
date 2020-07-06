package com.lagou.edu.service;

import com.lagou.edu.service.fallback.AuthCodeServiceFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 21:24:45
 */
@FeignClient(value = "lagou-service-code", path = "/api/code", fallback = AuthCodeServiceFeignClientFallback.class)
public interface AuthCodeServiceFeignClient {

    @GetMapping("/validate/{email}/{code}")
    public int validateAuthCode(@PathVariable("email") String email, @PathVariable("code") String code);
}
