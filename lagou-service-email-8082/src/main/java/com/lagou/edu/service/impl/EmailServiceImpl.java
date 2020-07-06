package com.lagou.edu.service.impl;

import com.lagou.edu.service.EmailService;
import com.lagou.edu.util.EmailUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:40:05
 */
@Service
@RefreshScope
public class EmailServiceImpl implements EmailService {

    @Value("${config.email.host}")
    private String emailHost;

    @Override
    public Boolean sendEmail(String email, String emailTitle, String message) {

        try {
            //这里邮箱地址和授权码暂时写死，安全性考虑没有放到配置文件中
            EmailUtils.sendEmail(emailHost, "ttudedong@163.com", "", email, emailTitle, message);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
        }
    }
}
