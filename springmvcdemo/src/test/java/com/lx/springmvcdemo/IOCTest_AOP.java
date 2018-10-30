package com.lx.springmvcdemo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lx.springmvcdemo.aop.MathCalculator;
import com.lx.springmvcdemo.config.MainConfigofAOP;

public class IOCTest_AOP {

	AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigofAOP.class);
	
	@Test
	public void test01() {
		//使用AOP一定要使用spring容器里面注册的bean来用，不能自己new一个MathCalculator，这样做是没有用的
		//MathCalculator me=new MathCalculator();
		//me.div(1, 1);
		MathCalculator mathCalculator=	(MathCalculator) applicationContext.getBean("mathCalculator");
		mathCalculator.div(1, 0);
	}
}
