package com.example.rabbitmq.config;

/**
 * Created by gutongwei on 2018/2/7.
 *
 * @desc Rabbit消息队列相关常量
 */
public class MQConstant {

    private MQConstant() {
    }

    /**
     * 根据路由键（routing key）匹配的交互机
     */
    public static final String TEST_DIRECT_EXCHANGE = "test.exchange";

    /**
     * 消息列队名称
     */
    public static final String TEST_QUEUE_DEFAULT_NAME = "test.queue.default";
    public static final String TEST_QUEUE_DEFAULT_NAME_2 = "test.queue.default2";


    /**
     * 路由名称
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。
     * 它是完全匹配、单播的模式。
     * 1.一个路由可以绑定多个消息列队。根据路由名称来发送消息的时候，所有与这个路由名称关联的都会收到消息。
     */
    public static final String TEST_ROUTING_KEY = "test.routing.key";


    /**
     * fanout 交互机
     */
    public static final String TEST_FANOUT_EXCHANGE = "test.fanout.exchange";

    /**
     * fanout交互机列队
     */
    public static final String TEST_FANOUT_QUEUE_NAME_ONE = "test.fanout.queue.one";
    public static final String TEST_FANOUT_QUEUE_NAME_TWO = "test.fanout.queue.two";
    public static final String TEST_FANOUT_QUEUE_NAME_THREE = "test.fanout.queue.three";
    public static final String TEST_TOPIC_EXCHANGE = "test.topic.exchange";


    /**
     * 延迟交互机
     */
    public static final String TEST_LATTER_EXCHANGE = "test.latter.exchange";

    /**
     * 死信发送列队
     */
    public static final String DEFAULT_LETTER_SENDER_QUEUE_NAME = "test.latter.dlx.queue";

    /**
     * dlx死信转发列队
     */
    public static final String DEFAULT_LETTER_RECEIVE_QUEUE_NAME = "test.latter.queue.receive";
}
