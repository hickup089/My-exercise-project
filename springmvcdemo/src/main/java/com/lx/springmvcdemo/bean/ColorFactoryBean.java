package com.lx.springmvcdemo.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个color对象
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean------getObject");
		return new Color();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	//是否是单例？
	//true，这个bean 是单例,只在容器中保存一份
	//false，多实例，每次都会创建一个新的bean
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
