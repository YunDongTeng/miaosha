package com.spark.miaosha.amqp;

import com.spark.miaosha.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/23.
 */

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = {RabbitMQConfig.ORDER_QUEUE})
    public void consume(String message) {
        System.out.println("消费者接收到消息：" + message);
    }


}
