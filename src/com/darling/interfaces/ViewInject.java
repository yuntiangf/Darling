package com.darling.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  View inject by id
 *
 */
@Target(ElementType.FIELD)// 表示用在字段上
@Retention(RetentionPolicy.RUNTIME)//表示声明周期是运行时
public @interface ViewInject {
   int value() default 0;
}
