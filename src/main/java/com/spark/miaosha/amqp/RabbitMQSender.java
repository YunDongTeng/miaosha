package com.spark.miaosha.amqp;

import com.spark.miaosha.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/23.
 */

@Component("rabbitMQSender")
public class RabbitMQSender {


    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        amqpTemplate.convertAndSend(RabbitMQConfig.ORDER_QUEUE, message);
        System.out.println("生产者发送消息：" + message);
    }

}
