package com.lagou.edu.service;


/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouAuthCodeService {
    /**
     * 创建验证码
     * @param email 邮件
     * @param code 验证码
     */
    void createAuthCode(String email, String code);

    /**
     * 校验验证码
     * @param email 邮件
     * @param code 验证码
     * @return int
     */
    int validateAuthCode(String email, String code);
}
