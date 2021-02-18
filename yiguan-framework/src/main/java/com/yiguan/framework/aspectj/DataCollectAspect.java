package com.yiguan.framework.aspectj;

import com.yiguan.common.annotation.DataCollect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据整理
 * 
 * @author ycz
 */
@Aspect
@Component
public class DataCollectAspect
{
    private static final Logger log = LoggerFactory.getLogger(DataCollectAspect.class);

    // 配置织入点
    @Pointcut("@annotation(com.yiguan.common.annotation.DataCollect)")
    public void dcPointCut()
    {

    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "dcPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult)
    {
        DataCollect dataCollect = getAnnotationLog(joinPoint);

        if (dataCollect == null)
        {
            return;
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private DataCollect getAnnotationLog(JoinPoint joinPoint)
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(DataCollect.class);
        }
        return null;
    }


}
