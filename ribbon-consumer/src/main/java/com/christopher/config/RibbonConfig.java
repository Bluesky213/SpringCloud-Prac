package com.christopher.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(value = "Consumer",configuration = RibbonConfig.class)
public class RibbonConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

/**
 * 默认轮询策略，取消注释可替换为随机策略
 */
//    @Bean
//    public IRule rule(){
//        return new RandomRule();
//    }
}
