package com.example.rabbitmq.config.custom;

import com.example.rabbitmq.config.MQConstant;
import com.example.rabbitmq.config.processor.AbstractMessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Rabbit消息接收者
 * Created by gutongwei on 2018/2/7.
 */
@Component
public class RabbitReceive {
    private Logger logger = LoggerFactory.getLogger(RabbitReceive.class);

    /**
     * 监听默认消息列队
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_QUEUE_DEFAULT_NAME)
    public void receiveMessage1(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("receiveMessage1:" +  processor.getLogMessage());
    }

    /**
     * 监听默认消息列队
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_QUEUE_DEFAULT_NAME)
    public void receiveMessage1_2(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("receiveMessage1_2：" + processor.getLogMessage());
    }

    /**
     * 监听默认消息列队
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_QUEUE_DEFAULT_NAME_2)
    public void receiveMessage2(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("RabbitReceive.receiveMessage2：" + processor.getLogMessage
                ());
    }


    /**
     * 监听fanout1
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_FANOUT_QUEUE_NAME_ONE)
    public void receiveFanout1(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("fanout1："  + "," + processor.getLogMessage());
    }
    /**
     * 监听fanout2
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_FANOUT_QUEUE_NAME_TWO)
    public void receiveFanout2(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("fanout2："  + processor.getLogMessage());
    }
    /**
     * 监听fanout3
     * <p>
     * MQConstant.DEFAULT_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.TEST_FANOUT_QUEUE_NAME_THREE)
    public void receiveFanout3(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("fanout3：" + processor.getLogMessage());
    }

    /**
     * 监听延迟的任务
     * MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME
     *
     * @param processor
     */
    @RabbitListener(queues = MQConstant.DEFAULT_LETTER_RECEIVE_QUEUE_NAME)
    public void receiveDelayMessage(AbstractMessageProcessor processor) {
        processor.callBack();
        logger.info("receiveDelayMessage："+ processor.getLogMessage());
    }
}