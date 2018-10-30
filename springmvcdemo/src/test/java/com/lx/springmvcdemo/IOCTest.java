package com.lx.springmvcdemo;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.lx.springmvcdemo.bean.Blue;
import com.lx.springmvcdemo.bean.Person;
import com.lx.springmvcdemo.config.MainConfig;
import com.lx.springmvcdemo.config.MainConfigII;

public class IOCTest {

	AnnotationConfigApplicationContext annotaionConfig=new AnnotationConfigApplicationContext(MainConfigII.class);
	
	@Test
	public void test04() {
	
	}
	
	private void printBeans() {
	String[] classname=	annotaionConfig.getBeanDefinitionNames();
	for(String name:classname) {
		System.out.println(name);
	}
	}
	
//	@Test
//	@SuppressWarnings("resource")
//	public void test01() {
//	//	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
//		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
//	String[] Allname=	applicationContext.getBeanDefinitionNames();
//	for(String name : Allname) {
//		System.out.println(name);
//	}
//	}
	
	@Test
	@SuppressWarnings("resource")
	public void test02() {
	//	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigII.class);
		Person person=(Person) applicationContext.getBean("person");
		
	//	Person person2=(Person) applicationContext.getBean("person");
		//System.out.println(person==person2);
	}
	
	@Test
	@SuppressWarnings("resource")
	public void test03() {
	//	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
		
		
		//动态获取当前系统变量环境
		ConfigurableEnvironment environment=annotaionConfig.getEnvironment();
		String property=environment.getProperty("os.name");
		System.out.println(property);
		
		
		
		String[] beanname= annotaionConfig.getBeanDefinitionNames();
		for(String name:beanname) {
			System.out.println(name);
		}
		Map<String,Person> persons= annotaionConfig.getBeansOfType(Person.class);
		System.out.println(persons);
	}
}
