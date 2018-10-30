package com.lx.springmvcdemo.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.lx.springmvcdemo.aop.LogAspects;
import com.lx.springmvcdemo.aop.MathCalculator;

/***
 * 
 * AOP:【动态代理】
 * 		指，在程序运行期间，动态的将某一段代码切入制定的位置进行运行
 * 
 * 1，导入AOP模块：spring AOP：（spring-aspects）pom.xml的包
 * 2,定义一个业务逻辑类MathCaluculator()：在业务逻辑的的时候将日志打印（方法之前，运行结束，出现异常）
 * 3，定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCaluculator运行到哪里了
 * 				通知方法：
 * 						前置通知(@Before)：logStart：在目标方法div运行之前运行
 * 						后置通知(@After)：logEnd：在目标方法div运行结束之后运行
 * 						返回通知(@AfterReturning)：logReturn：在目标正常返回之后运行
 * 						异常通知(@AfterThrowing)：logException：在目标出现异常之后运行
 * 						环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint。procced（））
 * 4,给切面类的目标方法标注何时何地运行（在LogAspects用通知注解）
 * 5，将切面类和业务逻辑类（目标所在类）都加入到容器中
 * 6，然后必须告诉spring，哪个是切面类（给切面类上加一个注解：@Aspect）
 * 【7】，给配置文件中加入@EnableAspectJAutoProxy【开启基于注解的AOP模式】
 * 					在spring中有很多的@EnableXXXX,都是开启某一个功能的
 * 					其中JoinPrint这个参数一定要放到其他值的前面
 * 
 * 
 * 三步：
 * 		1），将业务逻辑组件和切面类都加入到容器中，告诉spring哪个是切面类（@Aspect）
 * 		2），在切面类里面每一个通知方法上标注通知注解，告诉spring什么时候运行（切入点表达式：	
 * 			@Pointcut("execution(public int com.lx.springmvcdemo.aop.MathCalculator.*(..))")）或者是@Before什么的
 * 		3），上面第七步，开启注解AOP模式：@EnableAspectJAutoProxy
 * 
 * 
 * AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，包括这个组件工作时候的功能是什么】
 * 		@EnableAspectJAutoProxy;开启AOP注解
 * 	1，@EnableAspectJAutoProxy是什么？
 * 			@Import(AspectJAutoProxyRegistrar.class)，给容器中倒入AspectJAutoProxyRegistrar
 * 		这个AspectJAutoProxyRegistrar是实现了ImportBeanDefinitionRegistrar那个接口，就是MianConfigII里面实现过的自定义
 * 		添加bean的一个接口；；；然后给容器注册一个internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator（注释自动创建程序）
 * 	2，AnnotationAwareAspectJAutoProxyCreator，
			3-->AspectJAwareAdvisorAutoProxyCreator	
				4-->AbstractAdvisorAutoProxyCreator
 * 					5-->AbstractAutoProxyCreator
 * 						实现了这两个接口：implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware 
 * 				最后这就是后置处理器（后置处理器就是在bean初始化前后做的事情）和自动装配BeanFactory
 * 
 *   5）AbstractAutoProxyCreator.setBeanFactory()
 *      AbstractAutoProxyCreator.postProcessBeforeInstantiation()后置处理器逻辑
 * 
 * 
 *   4）AbstractAdvisorAutoProxyCreator.setBeanFactory()-》initBeanFactory（）:这个也重写了beanFactory
 * 
 * 
 * 		2）AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 * 
 * 其工作流程：
 * 			1），创建IOC容器，传入配置类创建MainConfigofAOP。class
 * 			2），注册配置类，调用refresh(),刷新容器
 * 			3）// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);；注册后置处理器来拦截bean的注册
					1），先获取ioc容器中已经定义了的需要创建对象的所有bean
					2),给容器中加BeanPostProcessor
					3），优先注册实现了priorityOrderrd接口的beanPostProcessor
					4），再给容器中注册实现了order接口的beanPostProcessor
					5),注册没有实现有限接口的BeanPostProcessor
 * @author hicku
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigofAOP {

	//业务逻辑类加入到容器中
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	//将切面类加入到容器中
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
	
}
