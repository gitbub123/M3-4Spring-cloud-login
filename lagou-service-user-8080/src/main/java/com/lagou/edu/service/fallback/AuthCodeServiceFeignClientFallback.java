package com.lagou.edu.service.fallback;

import com.lagou.edu.service.AuthCodeServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@Component
public class AuthCodeServiceFeignClientFallback implements AuthCodeServiceFeignClient {
    @Override
    public int validateAuthCode(String email, String code) {
        //超时
        return 2;
    }
}
