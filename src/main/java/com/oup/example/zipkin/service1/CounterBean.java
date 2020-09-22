package com.oup.example.zipkin.service1;

import org.springframework.stereotype.Component;

@Component
public class CounterBean {

    private int counter;

    public String someMethod(String body) {
        return "" + ++counter;
    }

}