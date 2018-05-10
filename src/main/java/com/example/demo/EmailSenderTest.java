package com.example.demo;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

@RestController
public class EmailSenderTest {

    @RequestMapping("/send")
    public void sendSimpleEmail(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.126.com");//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(25);//默认端口，标准的SMTP端口
        mailSender.setUsername("xxyuchen@126.com");//用户名
        mailSender.setPassword("*******");//密码

        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("xxyuchen@126.com");//发件人
        message.setTo("963839531@qq.com");//收件人
        message.setSubject("测试报告");//主题
        message.setText("邮件发送报告，有没有送达啊！");//正文
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }
}
