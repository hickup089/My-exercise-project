package com.lx.springmvcdemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition{



	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//3.获取当前环境信息
		Environment environment =context.getEnvironment();
		String osname=environment.getProperty("os.name");
		if(osname.contains("linux")) {
			return true;
		}
		return false;
	}
}
