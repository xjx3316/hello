package com.didispace.hello.controller;

import com.didispace.hello.properties.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xjx on 2018/11/12.
 */
@RestController
public class HelloController {

    @Autowired
    private BookProperties book;
    @Autowired
    private CounterService counterService;
    @Autowired
    private DiscoveryClient discoveryclient;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable String name) {
        counterService.increment("name " + name);
//        System.out.println(name);
//        System.out.println(book.getAuthor()+" "+book.getName()+" "+book.getDesc());
//        System.out.println(book.getA()+" "+book.getB()+" "+book.getC());
        return "你好 "+name;
    }
}
