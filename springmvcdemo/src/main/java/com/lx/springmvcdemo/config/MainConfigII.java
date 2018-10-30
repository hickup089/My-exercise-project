package com.lx.springmvcdemo.config;

import java.awt.event.WindowStateListener;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.lx.springmvcdemo.bean.Color;
import com.lx.springmvcdemo.bean.ColorFactoryBean;
import com.lx.springmvcdemo.bean.Person;
import com.lx.springmvcdemo.bean.Red;
import com.lx.springmvcdemo.condition.LinuxCondition;
import com.lx.springmvcdemo.condition.MyImportBeanDefinitionRegistart;
import com.lx.springmvcdemo.condition.MyImportSelecter;
import com.lx.springmvcdemo.condition.WindowCondition;


//类中组建统一设置，这个conditional里面的是一个数组，只有满足这个条件，这个类里面的bean才会生效
@Conditional({WindowCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelecter.class,MyImportBeanDefinitionRegistart.class})
//快速导入组件的注解，import，可以使用单个，也可以使用数组,这样就会自动导入这个组件
public class MainConfigII {

	/*Scope,设置组件作用域
	 *  * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * prototype：多实例，ioc启动的时候，并不会去添加这个person对象，而是在每次调用的时候new一次
	 * singleton：单实例，也是默认值，会一直使用同一个
	 * request：同一次请求创建一个实例
	 * session：同一个session创建一个实例
	 * 
	 * 
	 * @lazy
	 * 懒加载：
	 * 只针对单实例bean，默认容器启动的时候创建bean
	 * 而懒加载则是，容器启动的时候不创建对象，而是第一次使用时候
	 * 创建对象并初始化
	 * 
	 * */
	
	//@Scope("singleton")//这个确定是单例还是多实例
	@Lazy  ///这个就是懒加载
	@Bean("person")
	public Person person() {
		System.out.println("启动，添加person类");
		return new Person("aj",33);
	}
	
	/***
	 * Conditional:按照条件注册bean
	 * 这个conditional也可以注册到类上面
	 * 意思也是一样，就是满足conditional这个注解里面的条件，这个类下面的所以bean才会生效
	 * @return
	 */
	
	
	/***
	 * 给容器中注册组件的注解
	 * 1),@Bean()：就像下面所演示的一样
	 * 2),@import()：可以快速导入不需要操作很复杂的组件，可以直接用数组批量导入
	 * 			其中，ID是默认的全类名
	 * 			ImportSelector:自定义返回bean，数组，
	 * 			importBeanDefinitionRegistart：手动注册bean到容器里面
	 * 
	 * 3),直接扫描某一个包下面的全部bean
	 * 4),FactoryBean,这个是spring提供的工厂bean
	 * 			1），默认获取调用的是bean调用getObject()的对象
	 * 			2），要获取工厂本身的话，可以用&ColorFactoryBean来获取，即&加上bean的ID
	 * @return
	 */
	
	
	@Bean   //这个就是工厂类
	public ColorFactoryBean ColorFactoryBean() {
		return new ColorFactoryBean();
	}
	
	@Conditional({WindowCondition.class})
	@Bean("abson")
	public Person person01() {
		return new Person("Abson",27);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linux")
	public Person person02() {
		return new Person("linux",48);
	}
}
