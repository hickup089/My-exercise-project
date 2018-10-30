package com.lx.springmvcdemo.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelecter implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[] {"com.lx.springmvcdemo.bean.Blue","com.lx.springmvcdemo.bean.Yellow"};
	}

}
