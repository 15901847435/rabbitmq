package com.example.rabbitmq.config.processor;


/**
 * Created by gutongwei on 2018/2/8.
 */
public class MobileAuthCodeProcessor extends AbstractMessageProcessor {

    private static final long serialVersionUID = 1L;

    public MobileAuthCodeProcessor(String mobile) {
        this.mobile = mobile;
    }

    private String mobile;


    @Override
    public void callBack() {
    }

    @Override
    public String getLogMessage() {
        return "发送手机验证码，手机号为：" + mobile;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
