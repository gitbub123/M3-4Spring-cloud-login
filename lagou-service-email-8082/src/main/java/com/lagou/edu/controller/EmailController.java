package com.lagou.edu.controller;

import com.lagou.edu.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:35:57
 */
@RestController
@RequestMapping("/api/email")
@RefreshScope
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Value("${config.email.templates.checkcode.title}")
    private String emailTitle;

    @Value("${config.email.templates.checkcode.content}")
    private String emailContent;

    /**
     * 发送验证码到邮箱,true成功，false失败
     * @param email
     * @param checkCode
     * @return
     */
    @GetMapping("/{email}/{code}")
    public Boolean sendMail(@PathVariable("email") String email,
                            @PathVariable("code") String checkCode) {
        String message = String.format(emailContent, checkCode);
        return emailService.sendEmail(email, emailTitle, message);
    }

}
