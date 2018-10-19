package com.lx.demo.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ResponseBody;


public class Person {
    private Integer id;

    private String age;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}