package com.example.demoemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class MailController {
    @Autowired
    JavaMailSenderImpl mailSender;
    @RequestMapping("/mail")
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("11111111@139.com");
        message.setFrom("11111111@qq.com");
        mailSender.send(message);
    }
    @RequestMapping("/mineMail")
    public String sendMineMail() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        helper.setTo("111111@qq.com");
        helper.setFrom("1111111111@qq.com");


        //上传文件
        helper.addAttachment("1.jpg",new File("D:\\images\\spring\\1.jpg"));
        helper.addAttachment("哈哈哈.docx",new File("D:\\images\\spring\\哈哈哈.docx"));

        mailSender.send(mimeMessage);
        return "发送成功";
    }

}
