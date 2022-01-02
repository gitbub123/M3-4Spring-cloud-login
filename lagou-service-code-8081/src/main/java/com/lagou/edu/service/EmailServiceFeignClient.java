package com.lagou.edu.service;

import com.lagou.edu.service.fallback.EmailServiceFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@FeignClient(value = "lagou-service-email", path = "/api/email", fallback = EmailServiceFeignClientFallback.class)
public interface EmailServiceFeignClient {

    @GetMapping("/{email}/{code}")
    Boolean sendMail(@PathVariable("email") String email, @PathVariable("code") String checkCode);

}
