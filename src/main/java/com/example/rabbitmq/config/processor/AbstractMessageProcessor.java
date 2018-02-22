package com.example.rabbitmq.config.processor;

import java.io.Serializable;

/**
 * Created by gutongwei on 2018/2/7.
 * 发送RabbitMq消息实现类
 */
public abstract class AbstractMessageProcessor implements Serializable {
    /**
     * 消息回复调用方法
     */
    public abstract void callBack();

    /**
     * 记录日志
     */
    public abstract String getLogMessage();
}
