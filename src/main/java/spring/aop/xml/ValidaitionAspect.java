package spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//使用order指定Aspect(切面)的优先级，值越小优先级越高
@Order(1)
@Aspect
@Component
public class ValidaitionAspect {

    public void validationArgs(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("validatie:"+Arrays.asList(args));
    }

}
