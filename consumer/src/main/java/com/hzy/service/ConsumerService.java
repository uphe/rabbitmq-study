/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzy.service;

import com.hzy.pojo.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author chnewei
 */
@Service
public class ConsumerService {

    @RabbitListener(queues = "queue_email")
    public void receiveEmail(Message msg) {
        //发送邮件操作，这里省略了,emailService.sendEmail(msg);
        System.out.println("接收发送邮件消息----" + String.valueOf(msg));

    }

    @RabbitListener(queues = "queue_sms")
    public void receiveSms(Message msg) {
        //发送短息操作，这里省略了,smsService.sendSms(msg);
        System.out.println("接收发送短信消息----" + String.valueOf(msg));

    }
}
