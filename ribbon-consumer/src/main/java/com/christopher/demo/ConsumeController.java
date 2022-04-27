package com.christopher.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon实现服务负载的例子
 * 业务服务bus（spring.application.name)有多个实例，在注入@LoadBalanced和@RibbonClient修饰的restTemplate后
 * 所有调用bus服务的请求都会进入负载
 * 负载均衡策略：1、轮询 （默认）     2、随机访问 ...
 */
@Controller
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;//注入配置类的RestTemplate

    @ResponseBody
    @RequestMapping(value = "/consume-example",method = RequestMethod.GET)
    public String hello(){
        //bus 是一个被消费的业务服务，有多个实例
        Object o = restTemplate.getForObject("http://bus/hello",String.class);
        return o.toString();
    }


}
