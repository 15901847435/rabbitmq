package com.example.rabbitmq.config.custom;

import com.example.rabbitmq.config.MQConstant;
import com.example.rabbitmq.config.processor.AbstractMessageProcessor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Rabbit消息发送者
 * Created by gutongwei on 2018/2/7.
 */
@Component
public class RabbitSender {
    @Autowired
    private RabbitTemplate template;

    /**
     * 发送实时消息
     *
     * @param message
     */
    public void sendMessage(AbstractMessageProcessor message) {
        template.convertAndSend(MQConstant.TEST_DIRECT_EXCHANGE, MQConstant.TEST_ROUTING_KEY, message);
    }

    public void sendFanoutMessage(AbstractMessageProcessor message) {
        template.convertAndSend(MQConstant.TEST_FANOUT_EXCHANGE, null, message);
    }

    /**
     * 发送延时消息
     *
     * @param message 消息
     * @param time 延迟时间
     */
    public void sendDelayMessage(AbstractMessageProcessor message, int time) {
        template.convertAndSend(MQConstant.TEST_LATTER_EXCHANGE, MQConstant.DEFAULT_LETTER_SENDER_QUEUE_NAME,
                message, new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setExpiration(String.valueOf(time));
                        return message;
                    }
                });
    }
}
