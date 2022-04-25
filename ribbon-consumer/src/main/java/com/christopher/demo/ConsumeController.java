package com.christopher.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumeController {

    @ResponseBody
    @RequestMapping(value = "/consume-example",method = RequestMethod.GET)
    public String hello(){
        Object restTemplate = new RestTemplate().getForObject("http://BUS/hello",Object.class);
        return "ok";
    }


}
