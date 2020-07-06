package com.lagou.edu.service;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:39:13
 */
public interface EmailService {

    Boolean sendEmail(String email, String emailTitle, String message);
}
