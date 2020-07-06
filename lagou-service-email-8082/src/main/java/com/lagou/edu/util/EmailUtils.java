package com.lagou.edu.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:42:28
 */
public class EmailUtils {

    public static void sendEmail(String mailHost, String mailFrom, String passwordMailFrom, String mailTo, String mailTitle, String mailContent)
            throws MessagingException {
        Properties properties = new Properties();
        //("mail.host","smtp.163.com" );
        properties.put("mail.smtp.host", mailHost);
        //
        properties.put("mail.transport.protocol", "smtp");
        //("mail.smtp.auth", true);
        properties.put("mail.smtp.auth", true);

        //使用java发送邮件5步骤
        //1.创建sesssion
        Session session = Session.getInstance(properties);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport transport = session.getTransport();
        //3.通过邮件用户名密码链接
        //transport.connect("ttudedong@163.com", "tddaaa520");
        transport.connect(mailFrom, passwordMailFrom);
        //4.创建邮件
        Message textMail = createTextMail(session, mailFrom, mailTo, mailTitle, mailContent);
        //5.发送电子邮件
        transport.sendMessage(textMail, textMail.getAllRecipients());
        //transport.close();
    }

    public static MimeMessage createTextMail(Session session, String mailFrom, String mailTo, String mailTitle, String mailContent)
            throws MessagingException {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //设置发件人 "ttudedong@163.com"
        message.setFrom(new InternetAddress(mailFrom));
        //设置收件人 "1224377983@qq.com"
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        //设置邮件标题
        message.setSubject(mailTitle);
        //设置邮件内容
        message.setContent(mailContent, "text/html;charset=UTF-8");
        return message;
    }

}
