/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzy.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chnewei
 */
@Configuration
public class RabbitConfig {

    //队列名称
    public static final String QUEUE_EMAIL = "queue_email";
    //队列名称
    public static final String QUEUE_SMS = "queue_sms";
    //交换器名称
    public static final String EXCHANGE = "exchange";
    //路由key
    public static final String ROUTING_KEY_EMAIL = "email";
    //路由key
    public static final String ROUTING_KEY_SMS = "sms";

    //创建队列
    @Bean
    public Queue getQueueEmail() {
        return new Queue(QUEUE_EMAIL);
    }

    //创建队列
    @Bean
    public Queue getQueueSms() {
        return new Queue(QUEUE_SMS);
    }

    //实例化交换机
    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange(EXCHANGE);
    }

    //绑定消息队列和交换机
    @Bean
    public Binding bindingEmail() {
        return BindingBuilder.bind(getQueueEmail()).to(getDirectExchange()).with(ROUTING_KEY_EMAIL);
    }

    //绑定消息队列和交换机
    @Bean
    public Binding bindingSms() {
        return BindingBuilder.bind(getQueueSms()).to(getDirectExchange()).with(ROUTING_KEY_SMS);
    }

}
