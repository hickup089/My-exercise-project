package com.lx.demo.Controller;


import com.lx.demo.Bean.Person;
import com.lx.demo.Bean.PersonDemo;
import com.lx.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@RestController
public class DemoController {

    @Autowired
    private PersonService personService;

 private   String driver = "com.mysql.jdbc.Driver";
 //jdbc:mysql://localhost:3306/jsp_db?useUnicode=true&characterEncoding=utf-8&useSSL=false
    private  String url = "jdbc:mysql://192.168.127.132:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private  String username = "root";
    private  String password = "1020422790";

    @RequestMapping(value = "Hellow")
    public String Hello(){
       Jedis jedis=new Jedis("192.168.127.132",6379);
     String a=  jedis.select(1);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        java.sql.Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, username, password);
           Statement statement= conn.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from personDemo");
            PersonDemo person=new PersonDemo();
            while (resultSet.next()){
               person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getString("age"));
                person.setName(resultSet.getString("name"));
            }
            System.out.println(person.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "a";
    }


    @RequestMapping(value = "getOne")
    public String getPersonById(){
       Person person= personService.getOne();
       return person.getName();
    }

    @RequestMapping(value = "insertOne")
    public int InsertOne(){
        Person person=new Person();
        person.setAge("12");
        person.setId(3);
        person.setName("aboson");
        int result=personService.Insert(person);

        System.out.println();
        return result;
    }
}
