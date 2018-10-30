package com.lx.springmvcdemo.aop;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/***
 * 切面类
 * @author hicku
 *
 *@Aspect:这个注解告诉spring，这个是一个切面类，而不是其他普通的类
 */


@Aspect
public class LogAspects {
	
	
	//抽取公共的切入点表达式
	//1，本类引用
	//2，其他的切面引用
	@Pointcut("execution(public int com.lx.springmvcdemo.aop.MathCalculator.*(..))")
	public void printCut() {}
	
	//@before,在目标方法之前切入，切入点表达式（指在哪个方法切入）
	//@Before(value = "public int com.lx.springmvcdemo.aop.MathCalculator.*(..)")
	//也可以用
	@Before("printCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] obj=joinPoint.getArgs();
		System.out.println("除法运行"+joinPoint.getSignature().getName()+"-------参数列表:"+Arrays.asList(obj));
	}
	
	
	@After("execution(public int com.lx.springmvcdemo.aop.MathCalculator.*(..))")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println("除法结束-------"+joinPoint.getSignature().getName());
	}
	
	
	//JoinPoint这个参数一定要放在其他值的前面，否则会报错
	@AfterReturning(value="printCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result) {
		System.out.println("除法返回正常-------运行结果（"+result+"）");
	}
	
	@AfterThrowing(value="printCut()",throwing="exception")
	public void logException(Exception exception) {
		System.out.println("除法异常-------异常信息:{"+exception.toString()+"}");
	}
}
