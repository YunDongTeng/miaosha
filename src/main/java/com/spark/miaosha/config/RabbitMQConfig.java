package com.spark.miaosha.config;

import com.spark.miaosha.amqp.OrderConfirmCallBack;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by admin on 2018/1/23.
 */

/*@Configuration
@AutoConfigureAfter(OrderConfirmCallBack.class)*/
public class RabbitMQConfig {

    public final static String ORDER_QUEUE = "order.queue";

    public final static String EXCHANGE_NAME = "order.exchange";

    @Bean
    public Queue queue() {
        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public Exchange buildExchange() {
        Exchange exchange = new DirectExchange(EXCHANGE_NAME);

        return exchange;
    }

}
