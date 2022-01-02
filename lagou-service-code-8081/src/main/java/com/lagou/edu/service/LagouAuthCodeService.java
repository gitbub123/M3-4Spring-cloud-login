package com.lagou.edu.service;


/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouAuthCodeService {

    void createAuthCode(String email, String code);

    int validateAuthCode(String email, String code);
}
