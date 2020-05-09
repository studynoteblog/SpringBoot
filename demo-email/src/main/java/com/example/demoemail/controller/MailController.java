package com.example.demoemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class MailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    TemplateEngine templateEngine;
    @RequestMapping("/mail")
    public String sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("邮件主题");
        message.setText("邮件内容");
        message.setTo("xxxxxx@139.com","aaaaaa@qq.com");
        message.setFrom("xxxxxxx@qq.com");
        javaMailSender.send(message);
        return "简单邮件发送成功！";
    }
    @RequestMapping("/mineMail")
    public String sendMineMail() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件主题
        helper.setSubject("这是一个邮件啊");


        //文本中添加图片
        helper.addInline("image1",new FileSystemResource("D:\\images\\spring\\1.jpg"));
        //邮件内容
        helper.setText("全栈学习笔记<a href='https://www.cnblogs.com/swzx-1213/'>百度一下</a>    <img src='cid:image1'></img>",true);

        //目标邮箱
        helper.setTo("xxxxxx@139.com");
        helper.setFrom("xxxxxx@qq.com");

        //附件添加图片
        helper.addAttachment("1.jpg",new File("D:\\images\\spring\\1.jpg"));
        //附件添加word文档
        helper.addAttachment("哈哈哈.docx",new File("D:\\images\\spring\\哈哈哈.docx"));

        javaMailSender.send(mimeMessage);
       return "复杂邮件发送！";
    }
    @RequestMapping("/thyMail")
    public String sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("这是一个thymeleaf模板邮件");
        messageHelper.setTo("xxxxxx@139.com");
        messageHelper.setFrom("qxxxxxx@qq.com");
        Context context = new Context();
        context.setVariable("name","这是一个新建的thymeleaf模板");
        context.setVariable("link","https://www.cnblogs.com/swzx-1213/");
        context.setVariable("image1","图片地址");
        String value = templateEngine.process("email.html",context);
        messageHelper.setText(value,true);
        javaMailSender.send(mimeMessage);
        return "邮件发送成功";
    }

}
