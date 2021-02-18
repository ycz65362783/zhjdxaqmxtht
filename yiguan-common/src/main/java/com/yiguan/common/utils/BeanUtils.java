package com.yiguan.common.utils;


import com.yiguan.common.constant.Constants;
import com.yiguan.common.utils.uuid.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bean 工具类
 * 
 * @author ycz
 */
public class BeanUtils extends org.springframework.beans.BeanUtils
{
    protected final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    /** Bean方法名中属性名开始的下标 */
    private static final int BEAN_METHOD_PROP_INDEX = 3;

    /** * 匹配getter方法的正则表达式 */
    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

    /** * 匹配setter方法的正则表达式 */
    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

    /**
     * Bean属性复制工具方法。
     * 
     * @param dest 目标对象
     * @param src 源对象
     */
    public static void copyBeanProp(Object dest, Object src)
    {
        try
        {
            copyProperties(src, dest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象的setter方法。
     * 
     * @param obj 对象
     * @return 对象的setter方法列表
     */
    public static List<Method> getSetterMethods(Object obj)
    {
        // setter方法列表
        List<Method> setterMethods = new ArrayList<Method>();

        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();

        // 查找setter方法

        for (Method method : methods)
        {
            Matcher m = SET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 1))
            {
                setterMethods.add(method);
            }
        }
        // 返回setter方法列表
        return setterMethods;
    }

    /**
     * 获取对象的getter方法。
     * 
     * @param obj 对象
     * @return 对象的getter方法列表
     */

    public static List<Method> getGetterMethods(Object obj)
    {
        // getter方法列表
        List<Method> getterMethods = new ArrayList<Method>();
        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();
        // 查找getter方法
        for (Method method : methods)
        {
            Matcher m = GET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 0))
            {
                getterMethods.add(method);
            }
        }
        // 返回getter方法列表
        return getterMethods;
    }

    /**
     * 检查Bean方法名中的属性名是否相等。<br>
     * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
     * 
     * @param m1 方法名1
     * @param m2 方法名2
     * @return 属性名一样返回true，否则返回false
     */

    public static boolean isMethodPropEquals(String m1, String m2)
    {
        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
    }


    /**
     * 根据字段名获取字段值
     *
     * @param fieldName 字段名
     * @param o 对象
     * @return 字段值
     * @throws Exception 异常
     *
     */
    public static Object getFieldValueByName(String fieldName, Object o) throws Exception {

        if (o instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) o;

            if (map.containsKey(fieldName)) {
                return map.get(fieldName);
            } else {
                return null;
            }
        }


        Object value = null;
        Field field = getFieldByName(fieldName, o.getClass());

        if (field != null) {
            field.setAccessible(true);// 类中的成员变量为private,在类外边使用属性值，故必须进行此操作
            value = field.get(o);// 获取当前对象中当前Field的value
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }

        return value;
    }

    /**
     * 根据字段名获取字段对象
     *
     * @param fieldName 字段名
     * @param clazz 包含该字段的类
     * @return 字段
     */
    public static Field getFieldByName(String fieldName, Class<?> clazz) {
        Field[] selfFields = clazz.getDeclaredFields();

        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }

        return null;
    }

    public static void initUpdateProperty(Object obj) {

        try {
            BeanUtils.setProperty(obj, "updateTime", new Date());
            BeanUtils.setProperty(obj, "updateBy", SecurityUtils.getUsername()==null?"":SecurityUtils.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 为对象的操作属性赋值
     *
     * @param obj
     */
    public static void setProperty(Object obj, String propertyName, Object value) {

        try {
            org.apache.commons.beanutils.BeanUtils.setProperty(obj, propertyName, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void initInsertProperty(Object obj) {
        try {
            BeanUtils.setProperty(obj, "id", IdUtils.fastSimpleUUID());
            BeanUtils.setProperty(obj, "createTime", new Date());
            BeanUtils.setProperty(obj, "createBy", SecurityUtils.getUsername()==null?"":SecurityUtils.getUsername());
            BeanUtils.setProperty(obj, "isDeleted", Constants.IS_DELETED.NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
