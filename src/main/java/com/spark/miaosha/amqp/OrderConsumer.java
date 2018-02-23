package com.spark.miaosha.amqp;

import com.rabbitmq.client.Channel;
import com.spark.miaosha.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/23.
 */

/*@Component
@RabbitListener(queues = {RabbitMQConfig.ORDER_QUEUE})*/
public class OrderConsumer implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        String msg = new String(message.getBody());

        System.out.println("消费者接受消息：" + msg);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}
