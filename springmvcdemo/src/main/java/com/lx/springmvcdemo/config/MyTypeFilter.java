package com.lx.springmvcdemo.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
	
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata =metadataReader.getAnnotationMetadata();
	
		//获取正在扫描类的信息
		ClassMetadata classMetadata =metadataReader.getClassMetadata();
		
		
		//获取当前资源路径
		Resource resource =metadataReader.getResource();
		
		//获取类名
	String classname=	classMetadata.getClassName();
	//判断，如果类名里面有er，则判断为符合过滤规则
		if(classname.contains("er")) {
			return true;
		}
	System.out.println("这个是类名:"+classname);
		return false;
	}

}
