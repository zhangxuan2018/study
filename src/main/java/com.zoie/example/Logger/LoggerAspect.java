package com.zoie.example.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Order(1)
@Component
public class LoggerAspect {

    final static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    /**
     * 定义一个方法，用于声明切入点表达式，方法中一般不需要添加其他代码
     * 使用@Pointcut声明切入点表达式
     * 后面的通知直接使用方法名来引用当前的切点表达式；如果是其他类使用，加上包名即可
     */
    @Pointcut("execution(* com.zoie.example.controller.*.*(..))")
    public void declearJoinPointExpression(){}

    /**
     * 前置通知
     * @param joinPoint
     */
   // @Before("declearJoinPointExpression()") //该标签声明次方法是一个前置通知：在目标方法开始之前执行
    public void beforMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.info("@Before method 【{}】 params【{}】",methodName,args);
    }
    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     * @param joinPoint
     */
    //@After("declearJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("@After method 【{}】 end",methodName);
    }
    /**
     * 返回通知（在方法正常结束执行的代码）
     * 返回通知可以访问到方法的返回值！
     * @param joinPoit
     */
    //@AfterReturning(value="declearJoinPointExpression()",returning="result")
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        logger.info("@AfterReturning this method【{}】,end result【{}】",methodName,result);
    }
    /**
     * 异常通知（方法发生异常执行的代码）
     * 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     * @param joinPoint
     * @param ex
     */
    //@AfterThrowing(value="declearJoinPointExpression()",throwing="ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        logger.error("@AfterThrowing this method【{}】,end.ex message【{}】",methodName,ex);
    }
    /**
     * 环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)
     * 环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即目标方法的返回值
     * @param joinPoint
     */
    @Around(value="declearJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint point){

        Object result = null;
        String methodName = point.getSignature().getName();

        try {
            //前置通知
            logger.info("@Around method【{}】,start参数【{}】 ",methodName,Arrays.asList(point.getArgs()));
            //执行目标方法
            result = point.proceed();
            //返回通知
            logger.info("@Around method【{}】,end结果【{}】 ",methodName,result);
        } catch (Throwable e) {
            //异常通知
            logger.error("@Around method【{}】,异常信息【{}】",methodName,e);
            throw new RuntimeException(e);
        }
        //后置通知
        logger.info("@Around method【{}】end",methodName);
        return result;
    }

}
