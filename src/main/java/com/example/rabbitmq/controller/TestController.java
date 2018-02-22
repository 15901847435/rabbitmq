package com.example.rabbitmq.controller;

import com.example.rabbitmq.config.custom.RabbitSender;
import com.example.rabbitmq.config.processor.MobileAuthCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gutongwei on 2018/2/22.
 */
@RequestMapping("")
@Controller
public class TestController {

    @Autowired
    private RabbitSender sender;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
//        sender.sendMessage(new MobileAuthCodeProcessor("159184735"));
        sender.sendDelayMessage(new MobileAuthCodeProcessor("159184735"),2000);
        return  "ok";
    }



}
