package com.lagou.edu.service.fallback;

import com.lagou.edu.service.EmailServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 17:34:30
 */
@Component
public class EmailServiceFeignClientFallback implements EmailServiceFeignClient {


    @Override
    public Boolean sendMail(String email, String checkCode) {
        return false;
    }
}
