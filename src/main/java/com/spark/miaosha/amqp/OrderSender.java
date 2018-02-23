package com.spark.miaosha.amqp;

import com.spark.miaosha.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/1/23.
 */
@Service("orderSender")
public class OrderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object message) {
        amqpTemplate.convertAndSend(RabbitMQConfig.ORDER_QUEUE, message);
    }
}
