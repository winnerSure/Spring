package spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoginAop {

    @Before("execution(public int spring.aop.MathCal.*(..))")  //传入接口
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
    }

    //后置通知，无论是否出现异常，都会执行
    @After("execution(public int spring.aop.MathCal.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end");
    }

    //返回通知，获取到方法的返回值
    @AfterReturning(value = "execution(public int spring.aop.MathCal.*(..)))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();  //注意，此处是getSignature不是getClass
        System.out.println("The method "+methodName+" end with "+result);
    }
}
