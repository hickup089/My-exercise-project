package com.lx.demo.Test;


import com.lx.demo.Bean.Person;
import com.lx.demo.DemoApplication;
import com.lx.demo.Service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RunAs;

@RunWith(SpringJUnit4ClassRunner.class) ///这个是必须的，引用Spring-Test框架的支持
@SpringBootTest(classes = DemoApplication.class) ///SpringBoot的启动类，必须
@WebAppConfiguration  ///这个是告诉程序，这个是一个web程序
public class TestDemo {

    private RestTemplate restTemplate =new RestTemplate();

    @Autowired
    private PersonService PersonService;


    @Test
    public void Hello(){
        Person person= PersonService.getOne();
        System.out.println(person.getName());
    }

    @Test
    public void Test3(){
        String url="http://localhost:8080/getOne";
      String person=  restTemplate.getForObject(url,String.class);
      System.out.println(person);
    }

}
