/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzy.service;

import com.hzy.pojo.Message;
import com.hzy.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chnewei
 */
@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(Message msg) {

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY_EMAIL, msg);
        System.out.println("Producer, " + String.valueOf(msg));
    }

    public void sendSms(Message msg) {

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY_SMS, msg);
        System.out.println("Producer, " + String.valueOf(msg));
    }
}
