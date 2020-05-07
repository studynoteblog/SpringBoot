package com.example.demolog.controller;

import com.example.demolog.annotation.MyLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 全栈学习笔记
 * @date 2020/5/3 15:26
 * @description
 */
@RestController
public class TestLogController {

    Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/testLog")
    @MyLog("测试一个日志")
    public void testLog(){
        logger.trace("这是trace级别的日志");
        logger.debug("这是debug级别的日志");
        logger.info("这是正常自定义日志");
        logger.warn("这是警告日志");
        logger.error("这是错误日志");
    }
}
