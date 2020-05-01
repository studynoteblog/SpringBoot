package com.example.demofilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.demofilter.filter")
public class DemoFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFilterApplication.class, args);
    }

}
