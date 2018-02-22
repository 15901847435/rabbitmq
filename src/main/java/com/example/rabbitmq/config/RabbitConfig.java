package com.example.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gutongwei on 2018/2/6.
 */
@Configuration
public class RabbitConfig {

    /**
     * Exchange：消息交换机
     * 建立交换机
     *
     * @return
     */
    @Bean
    public DirectExchange defaultDirectExchange() {
        return new DirectExchange(MQConstant.TEST_DIRECT_EXCHANGE, true, false);
    }


    /**
     * 建立默认消息列队
     *
     * @return
     */
    @Bean
    public Queue defaultQueue() {
        Queue queue = new Queue(MQConstant.TEST_QUEUE_DEFAULT_NAME, true);
        return queue;
    }

    /**
     * 绑定消息列队(没有routing_key的时候就是列队名称)
     *
     * @return
     */
    @Bean
    public Binding bindingDefault() {
        return BindingBuilder.bind(defaultQueue()).to(defaultDirectExchange()).with(MQConstant.TEST_ROUTING_KEY);
    }


    /**
     * 建立默认消息列队
     *
     * @return
     */
    @Bean
    public Queue defaultQueue2() {
        Queue queue = new Queue(MQConstant.TEST_QUEUE_DEFAULT_NAME_2, true);
        return queue;
    }

    /**
     * 绑定消息列队(没有routing_key的时候就是列队名称)
     *
     * @return
     */
    @Bean
    public Binding bindingDefault2() {
        return BindingBuilder.bind(defaultQueue2()).to(defaultDirectExchange()).with(MQConstant.TEST_ROUTING_KEY);
    }


    /**
     * 简历Fanout交互机
     * 每个发到 fanout 类型交换器的消息都会分到所有绑定的队列上去。
     * fanout 交换器不处理路由键，只是简单的将队列绑定到交换器上，每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上。
     * 很像子网广播，每台子网内的主机都获得了一份复制的消息。fanout 类型转发消息是最快的。
     *
     * @return
     */
    @Bean
    public FanoutExchange defaultFanoutExchange() {
        return new FanoutExchange(MQConstant.TEST_FANOUT_EXCHANGE, true, false);
    }

    @Bean
    public Queue fanoutQueueOne() {
        Queue queue = new Queue(MQConstant.TEST_FANOUT_QUEUE_NAME_ONE, true);
        return queue;
    }

    @Bean
    public Binding bindingFanoutQueueOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(defaultFanoutExchange());
    }

    @Bean
    public Queue fanoutQueueTwo() {
        Queue queue = new Queue(MQConstant.TEST_FANOUT_QUEUE_NAME_TWO, true);
        return queue;
    }

    @Bean
    public Binding bindingFanoutQueueTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(defaultFanoutExchange());
    }

    @Bean
    public Queue fanoutQueueThree() {
        Queue queue = new Queue(MQConstant.TEST_FANOUT_QUEUE_NAME_THREE, true);
        return queue;
    }

    @Bean
    public Binding bindingFanoutQueueThree() {
        return BindingBuilder.bind(fanoutQueueThree()).to(defaultFanoutExchange());
    }

    /*******************延时任务**********************/
    /**
     * Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
     * @return
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(MQConstant.TEST_LATTER_EXCHANGE, true, false);
    }

    @Bean
    public Queue repeatTradeQueue() {
        Queue queue = new Queue(MQConstant.DEFAULT_LETTER_RECEIVE_QUEUE_NAME, true, false, false);
        return queue;
    }

    @Bean
    public Binding repeatTradeBinding() {
        return BindingBuilder.bind(repeatTradeQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_LETTER_RECEIVE_QUEUE_NAME);
    }

    /**
     * 建立延迟任务列队
     * <p>
     * 延迟消息发送至MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME列队
     * 接收时会使用EXCHANGE转发值MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME列队
     *
     * @return
     */
    @Bean
    public Queue deadLetterQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", MQConstant.TEST_LATTER_EXCHANGE);//出现dead letter之后将dead letter重新发送到指定exchange
        arguments.put("x-dead-letter-routing-key", MQConstant.DEFAULT_LETTER_RECEIVE_QUEUE_NAME);//出现dead letter之后将dead letter重新按照指定的routing-key发送
        Queue queue = new Queue(MQConstant.DEFAULT_LETTER_SENDER_QUEUE_NAME, true, false, false, arguments);
        return queue;
    }

    /**
     * 延迟任务绑定交互机
     *
     * @return
     */
    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_LETTER_SENDER_QUEUE_NAME);
    }
    /*******************延时任务**********************/
}
