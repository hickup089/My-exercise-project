package com.lx.springmvcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lx.springmvcdemo.bean.Person;
import com.lx.springmvcdemo.config.MainConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//这个是配置文件的使用方法
//ApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean.xml");
//   Person person=(Person) applicationContext.getBean("person");
//   System.out.println(person);
    	
    	
    	ApplicationContext applicationContext =new	AnnotationConfigApplicationContext(MainConfig.class);
    	Person person=(Person) applicationContext.getBean("person22");
    System.out.println(person);
    String[] personname= applicationContext.getBeanNamesForType(Person.class);
    for(String name:personname) {
    	System.out.println(name);
    }
}
}
