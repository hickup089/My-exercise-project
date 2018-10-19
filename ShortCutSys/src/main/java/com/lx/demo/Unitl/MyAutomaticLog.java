package com.lx.demo.Unitl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) ///这个注解是说可以让这个MyAutomaticLog标注的地方
@Retention(RetentionPolicy.RUNTIME) ///这个注解是指保留时期
public @interface MyAutomaticLog {
    String value();
}
