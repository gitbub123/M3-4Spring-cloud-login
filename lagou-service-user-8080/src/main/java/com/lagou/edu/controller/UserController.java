package com.lagou.edu.controller;

import com.lagou.edu.pojo.LagouToken;
import com.lagou.edu.service.LagouUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private LagouUserService lagouUserService;

    /**
     * 注册接口，true成功，false失败
     * /user/register/{email}/{password}/{code}
     * @param response
     * @param email
     * @param password
     * @param code
     * @return
     */
    @GetMapping("/register/{email}/{password}/{code}")
    public boolean register(HttpServletResponse response,
                            @PathVariable("email") String email,
                            @PathVariable("password") String password,
                            @PathVariable("code") String code){
        if(email==null || password==null || code==null){
            System.out.println("======这里模拟ip防暴刷，直接返回true=====");
            return true;
        }else{
            System.out.println("======进入注册======");
            //注册，注册并生成LagouToken
            LagouToken lagouToken = lagouUserService.register(email,password,code);
            if(lagouToken != null){
                //将token写入cookie中
                response.addCookie(new Cookie("token",lagouToken.getToken()));
                return true;
            }
            return false;
        }
    }

    /**
     * 通过邮箱验证是否已注册
     * @param email
     * @return true-已注册，false-未注册
     */
    @GetMapping("/isRegistered/{email}")
    public boolean isRegistered(@PathVariable("email") String email) {
        System.out.println("======进入邮箱是否已注册验证========");
        return lagouUserService.isRegistered(email);
    }

    /**
     * 登录接口
     * @param response
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/login/{email}/{password}")
    public String login(HttpServletResponse response,
                        @PathVariable String email,
                        @PathVariable String password) {
        System.out.println("======进入登录======");
        LagouToken lagouToken = lagouUserService.login(email, password);
        if (lagouToken != null) {
            //将token写入cookie中
            response.addCookie(new Cookie("token",lagouToken.getToken()));
            return lagouToken.getEmail();
        }
        return "";
    }

    /**
     * 根据token查询用户登录邮箱
     * @param token
     * @return
     */
    @GetMapping("/info/{token}")
    public String getEmailByToken(@PathVariable String token) {
        return lagouUserService.getEmailByToken(token);
    }

}
