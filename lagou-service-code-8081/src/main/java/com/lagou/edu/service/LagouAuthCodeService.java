package com.lagou.edu.service;


/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:07:13
 */
public interface LagouAuthCodeService {

    void createAuthCode(String email, String code);

    int validateAuthCode(String email, String code);
}
