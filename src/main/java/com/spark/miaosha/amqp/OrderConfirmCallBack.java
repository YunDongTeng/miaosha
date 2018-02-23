package com.spark.miaosha.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/23.
 */
@Component("orderConfirmCallBack")
public class OrderConfirmCallBack implements RabbitTemplate.ConfirmCallback {


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.out.println("confirm--:correlationData:" + correlationData + ",ack:" + ack + ",cause:" + s);
    }
}
