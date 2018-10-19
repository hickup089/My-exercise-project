package com.example.servermember.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("member")
    public List<String> getMemberAll() {

        List<String> user=new ArrayList<String>();
        user.add("zhangsan");
        user.add("lisi");
        user.add("wangwu");
        return user;
    }
}
