package spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Order(2)
@Aspect
@Component
public class LoginAop {

    //    定义一个方法，用于声明切入点表达式，一般该方法内容为空
    //使用@Pointcut声明切入点表达式
    @Pointcut("execution(public int spring.aop.MathCal.*(..))")
    public void declareJoinPointExpression(){ }

    //引用切入点表达式,不同包下的引用，加包名和类型，例如：spring.aop.LoginAop.declareJoinPointExpression()
    @Before("declareJoinPointExpression()")  //传入切点类
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
    }

    //后置通知，无论是否出现异常，都会执行
//    @After("execution(public int spring.aop.MathCal.*(..))")
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end");
    }

    //返回通知，获取到方法的返回值
    //在方法结束后执行
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end with "+result);
    }

    //异常通知
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" error on: "+e);
    }

//    //环绕通知
//    @Around("declareJoinPointExpression()")
//    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        Object result = null;
//        try {
//            //前置通知
//            System.out.println("The Method "+methodName+" begin");
//            //执行
//            result = proceedingJoinPoint.proceed();
//            //后置通知
//            System.out.println("The method "+methodName+" ends with "+result);
//        } catch (Throwable throwable) {
//
////            throwable.printStackTrace();
//            //异常通知
//            System.out.println("The method "+methodName+" error on "+throwable);
//        }
//        return result;
//    }
}
