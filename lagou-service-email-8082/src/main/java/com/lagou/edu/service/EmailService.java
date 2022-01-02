package com.lagou.edu.service;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param email 邮件
     * @param emailTitle 邮件头
     * @param message 信息
     * @return Boolean
     */
    Boolean sendEmail(String email, String emailTitle, String message);
}
