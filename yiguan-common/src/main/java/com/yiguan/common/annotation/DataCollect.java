package com.yiguan.common.annotation;

import java.lang.annotation.*;

/**
 * 数据整理注解
 * 
 * @author ycz
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataCollect
{
     //表
     Class<?> table() default Void.class;
     //外键
     public String foreignKey() default "";

     Class<?> returnTypeClass() default Void.class;

     Class<?> searchMapper() default Void.class;


}
