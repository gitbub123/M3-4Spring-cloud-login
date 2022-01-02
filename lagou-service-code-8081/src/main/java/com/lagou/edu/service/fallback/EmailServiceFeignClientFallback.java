package com.lagou.edu.service.fallback;

import com.lagou.edu.service.EmailServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@Component
public class EmailServiceFeignClientFallback implements EmailServiceFeignClient {


    @Override
    public Boolean sendMail(String email, String checkCode) {
        return false;
    }
}
