package com.lagou.edu.service;

import com.lagou.edu.pojo.LagouToken;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouUserService {

    /**
     * 注册
     * @param email
     * @param password
     * @param code
     * @return
     */
    LagouToken register(String email, String password, String code);

    /**
     * 通过邮箱验证是否已注册
     * @param email
     * @return
     */
    boolean isRegistered(String email);

    /**
     * 登录接口
     * @param email
     * @param password
     * @return
     */
    LagouToken login(String email, String password);

    /**
     * 根据token查询用户登录邮箱
     * @param token
     * @return
     */
    String getEmailByToken(String token);
}
