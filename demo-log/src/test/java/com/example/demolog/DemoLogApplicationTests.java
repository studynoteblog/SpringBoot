package com.example.demolog;

import com.example.demolog.controller.TestLogController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoLogApplicationTests {

    @Test
    void contextLoads() {
        String a = "123";
        String b = a.replaceAll(a,"");
        System.out.println(b);
    }

}
