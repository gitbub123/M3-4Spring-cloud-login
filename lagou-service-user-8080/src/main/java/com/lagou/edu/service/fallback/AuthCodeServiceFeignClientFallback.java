package com.lagou.edu.service.fallback;

import com.lagou.edu.service.AuthCodeServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 21:27:10
 */
@Component
public class AuthCodeServiceFeignClientFallback implements AuthCodeServiceFeignClient {
    @Override
    public int validateAuthCode(String email, String code) {
        //超时
        return 2;
    }
}
