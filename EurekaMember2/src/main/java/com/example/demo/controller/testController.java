package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class testController {

    @Value("${server.port}")
    private String port;
        @RequestMapping("hello")
        public List<String> getMemberAll() {

            List<String> user=new ArrayList<String>();
            user.size();
            user.add("zhangsan");
            user.add("lisi");
            user.add("wangwu");
            user.add(port);
            return user;
        }
}
