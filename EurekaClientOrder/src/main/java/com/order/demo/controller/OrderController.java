package com.order.demo.controller;

import com.order.demo.service.OrderMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMemberService orderMemberService;

    @RequestMapping("getHello")
    public List<String> getOrderAll(){
      return   orderMemberService.getOrderUser();
    }
}
