package com.lx.springmvcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.lx.springmvcdemo.bean.Person;
import com.lx.springmvcdemo.service.BookService;

//告诉spring，这是一个配置类
@Configuration
@ComponentScan(value="com.lx.springmvcdemo",includeFilters= {

		@Filter(type=FilterType.CUSTOM,classes= {MyTypeFilter.class})  ////这个是自定义filter
},useDefaultFilters=false)
//@ComponentScan是一个告诉个配置文件要扫描哪里
//@value，包的位置
//@excludeFileters这个是告诉ComponentScan不扫描哪里，同理有一个includeFilters是至扫描哪里
//@Filter，就是扫描哪里
//FilterType.CUSTOM自定义规则，写一个自定义类MyTypeFilter
//@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
//@Filter(type=FilterType.ASSIGNABLE_TYPE,classes= {BookService.class})
//useDefaultFilters不用默认过滤器
public class MainConfig {

	//注册一个bean
	@Bean(value="person22")
	public Person person() {
		return new Person("lisi",23);
	}
	
}
