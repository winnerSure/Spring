package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class AroundAspect {
    //环绕通知
    @Around("spring.aop.LoginAop.declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object result = null;
        try {
            //前置通知
            System.out.println("a:The Method "+methodName+" begin");
            //执行
            result = proceedingJoinPoint.proceed();
            //后置通知
            System.out.println("a:The method "+methodName+" ends with "+result);
        } catch (Throwable throwable) {

//            throwable.printStackTrace();
            //异常通知
            System.out.println("a:The method "+methodName+" error on "+throwable);
            throw new RuntimeException(throwable);
        }
        return result;
    }
}
