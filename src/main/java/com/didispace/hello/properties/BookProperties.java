package com.didispace.hello.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xjx on 2018/11/12.
 */
@Component
public class BookProperties {

    @Value("${book.name}")
    private String name;
    @Value("${book.author}")
    private String author;
    @Value(("${book.desc}"))
    private String desc;
    @Value(("${a}"))
    private String a;
    @Value(("${b}"))
    private String b;
    @Value(("${c}"))
    private String c;


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesc() {
        return desc;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }
}
