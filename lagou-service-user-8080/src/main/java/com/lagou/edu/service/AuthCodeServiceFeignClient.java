package com.lagou.edu.service;

import com.lagou.edu.service.fallback.AuthCodeServiceFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@FeignClient(value = "lagou-service-code", path = "/api/code", fallback = AuthCodeServiceFeignClientFallback.class)
public interface AuthCodeServiceFeignClient {

    /**
     * 校验code
     * @param email
     * @param code
     * @return
     */
    @GetMapping("/validate/{email}/{code}")
    public int validateAuthCode(@PathVariable("email") String email, @PathVariable("code") String code);
}
