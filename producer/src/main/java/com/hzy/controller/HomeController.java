package com.hzy.controller;

import com.hzy.pojo.Message;
import com.hzy.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin   //允许跨域访问注解
@RestController  //控制器各服务返回数据为字符串，如果return是对象或对象列表，Spring Boot自动转换成JSON给前端。
public class HomeController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody Message msg) {
        producerService.sendEmail(msg);
        return "success";
    }

    @PostMapping("/sendsms")
    public String sendSms(@RequestBody Message msg) {
        producerService.sendSms(msg);
        return "success";
    }
}
