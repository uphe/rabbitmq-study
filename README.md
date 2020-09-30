# rabbitmq-study

## 安装RabbitMQ
    
RabbitMQ是实现了高级消息队列协议（AMQP）的开源消息代理软件（亦称面向消息的中间件）。RabbitMQ服务器是用Erlang语言编写的。

一、安装Erlang
        otp_win64_23.0

二、RabbitMQ安装
        rabbitmq-server-3.8.5

三、运行RabbitMQ
1、打开cmd命令行窗口

2、进入到sbin目录下执行：rabbitmq-plugins enable rabbitmq_management



3、开启服务执行：rabbitmq-server



4、打开浏览器访问：http://localhost:15672
       

默认UserName:guest    Password:guest

## 测试RabbitMQ

postman测试

一、Producer 消息提供者

1.post：localhost:8081/producer/sendemail

参数：{
  "id": "1000",
  "content": "你好！email"
}

2.post：localhost:8081/producer/sendsms

参数：{
  "id": "1001",
  "content": "你好！sms"
}

2、Consumer 消息消费者

运行后，观察队列消息。
