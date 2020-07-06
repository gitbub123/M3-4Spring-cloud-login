package com.lagou.edu.service.fallback;

import com.lagou.edu.service.UserServiceGateWayFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author tudedong
 * @description
 * @date 2020-07-06 10:13:03
 */
@Component
public class UserServiceGateWayFeignClientFallback implements UserServiceGateWayFeignClient {

    @Override
    public String info(String token) {
        return "NOT FOUND";
    }
}
