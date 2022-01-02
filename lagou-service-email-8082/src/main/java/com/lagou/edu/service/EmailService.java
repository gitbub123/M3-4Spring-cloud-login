package com.lagou.edu.service;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface EmailService {

    Boolean sendEmail(String email, String emailTitle, String message);
}
