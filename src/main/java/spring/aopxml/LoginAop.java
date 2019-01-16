package spring.aopxml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class LoginAop {

    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
    }


    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end");
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end with "+result);
    }

    //异常通知
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" error on: "+e);
    }
}
