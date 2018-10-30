package com.lx.springmvcdemo.condition;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是不是windows系统
public class WindowCondition implements Condition {

	
	/***
	 * ConditionContext：判断条件能使用的上下文
	 * AnnotatedTypeMetadata：注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
	
		//1,能获取ioc使用的beanFatory
		context.getBeanFactory();
		
		//2，获取类加载器
	ClassLoader classLoader=context.getClassLoader();
		
		//3.获取当前环境信息
	Environment environment =context.getEnvironment();
	
	//4,获取bean的定义注解
	BeanDefinitionRegistry beanDefinitionRegistry=context.getRegistry();
	
	//判断是否是windows系统，如果是，则返回true，可以注册bean
	String osname=environment.getProperty("os.name");
	if(osname.contains("Windows")) {
		return true;
	}
		return false;
	}

}
