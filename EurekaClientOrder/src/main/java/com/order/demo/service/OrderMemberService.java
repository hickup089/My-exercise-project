package com.order.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderMemberService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getOrderUser(){

       return restTemplate.getForObject("http://EUREKAMEMBER/hello",List.class);
    }
}
