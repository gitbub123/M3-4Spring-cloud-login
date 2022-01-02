package com.lagou.edu.service.fallback;

import com.lagou.edu.service.UserServiceGateWayFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@Component
public class UserServiceGateWayFeignClientFallback implements UserServiceGateWayFeignClient {

    @Override
    public String info(String token) {
        return "NOT FOUND";
    }
}
