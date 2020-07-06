package com.lagou.edu.controller;

import com.lagou.edu.service.EmailServiceFeignClient;
import com.lagou.edu.service.LagouAuthCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:02:52
 */
@RestController
@RequestMapping("/api/code")
public class AuthCodeController {

    @Autowired
    private LagouAuthCodeService lagouAuthCodeService;

    @Autowired
    private EmailServiceFeignClient emailServiceFeignClient;

    /**
     * 生成验证码并发送到邮箱，成功true，失败false
     * /code/create/{email}
     * @param email
     * @return
     */
    @GetMapping("/create/{email}")
    public boolean createAuthCode(@PathVariable("email") String email) {
        System.out.println("========获取验证码=======");
        //1.生成验证码
        String code = getRandomCode();
        lagouAuthCodeService.createAuthCode(email, code);
        //2.发送到邮箱
        return emailServiceFeignClient.sendMail(email, code);
    }

    /**
     * 校验验证码是否正确
     * 0-正确，1-错误，2-超时
     * @param email
     * @param code
     * @return
     */
    @GetMapping("/validate/{email}/{code}")
    public int validateAuthCode(@PathVariable("email") String email, @PathVariable("code") String code) {
        return lagouAuthCodeService.validateAuthCode(email, code);
    }

    /**
     * 随机生成6位数
     * @return
     */
    private String getRandomCode() {
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }

}
