package com.didispace.hello.controller;

import com.didispace.hello.properties.BookProperties;
import com.netflix.discovery.converters.Auto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by xjx on 2018/11/12.
 */
@RestController
public class HelloController {

    private final Logger LOG = Logger.getLogger(HelloController.class);
    @Autowired
    private BookProperties book;
//    @Autowired
//    private CounterService counterService;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() throws Exception{
        ServiceInstance instance = client.getLocalServiceInstance();
        //让处理线程等上几秒钟
        int sleepTime = new Random().nextInt(3000);
        LOG.info("sleepTime: "+sleepTime);
        Thread.sleep(sleepTime);

        LOG.info("/hello, host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        return "hello springcloud";
    }

    @RequestMapping("/index2")
    public String index2(){
        return restTemplate.getForEntity("http://RIBBON-CONSUMER/helloConsumer2",String.class).getBody();
    }

}
