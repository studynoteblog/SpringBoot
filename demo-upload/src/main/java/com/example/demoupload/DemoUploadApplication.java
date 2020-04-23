package com.example.demoupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DemoUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUploadApplication.class, args);
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大   KB,MB
        DataSize maxSize = DataSize.ofMegabytes(10);
        DataSize requestMaxSize = DataSize.ofMegabytes(30);
        factory.setMaxFileSize(maxSize);
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(requestMaxSize);
        return factory.createMultipartConfig();
    }

}
