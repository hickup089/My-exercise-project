package com.zuul.demozuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class DemozuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemozuulApplication.class, args);
    }
}
