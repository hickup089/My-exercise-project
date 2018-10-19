package com.lx.demo.Unitl;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Order(1)标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
@Order(2)
public class SystemLogAutomatic {

    private static final Logger log=Logger.getLogger(SystemLogAutomatic.class);

    //这里是标记哪一个层，annotation是指只扫描标注了MyAutomatic的方法
    @Pointcut(("execution(* com.lx.demo.Service.*.*(..)) && @annotation(MyAutomaticLog)"))
    public void SystemLog(){};

    @Before("SystemLog()")
    public void BeforeService(JoinPoint joinPoint){
        Signature request=joinPoint.getSignature();
     for(int i=0;i<joinPoint.getArgs().length;i++){
         System.out.println(joinPoint.getArgs()[i]);

     }
       System.out.println(joinPoint.getSignature());
        log.info(request);
    }
}
