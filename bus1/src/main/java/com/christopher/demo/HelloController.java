package com.christopher.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HelloController {

    private final Logger logger = Logger.getLogger(HelloController.class.getName());

    @Autowired
    DiscoveryClient client;

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello(){
        List<DiscoveryClient> clients = ((CompositeDiscoveryClient) client).getDiscoveryClients();
        for (DiscoveryClient discoveryClient : clients) {
            discoveryClient.getServices().forEach(name->{
//                logger.info(discoveryClient.getInstances(name));
//                logger.info(discoveryClient.getServices(+":"+discoveryClient.getPort()+"|"+discoveryClient.getInstanceId());
            });
        }
        HashMap map = new LinkedHashMap();
        map.put("key","value");
        return map;
    }


}
