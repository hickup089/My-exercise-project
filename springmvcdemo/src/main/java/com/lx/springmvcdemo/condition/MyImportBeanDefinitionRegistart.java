package com.lx.springmvcdemo.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.lx.springmvcdemo.bean.RianBow;
/***
 * 导入组建的的方法之一
 * @author hicku
 *
 */
public class MyImportBeanDefinitionRegistart implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
	
		//判断是否有某一个bean
	boolean definition=	registry.containsBeanDefinition("com.lx.springmvcdemo.bean.Red");
	boolean definition2=	registry.containsBeanDefinition("com.lx.springmvcdemo.bean.Blue");
	
	if(definition&&definition2) {
		
		//制定bean的定义信息
		RootBeanDefinition beanDefinition=new RootBeanDefinition(RianBow.class);
		//手动给容器注册一个
		registry.registerBeanDefinition("rianbow", beanDefinition);
	}

	}

}
