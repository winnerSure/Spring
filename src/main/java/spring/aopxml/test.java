package spring.aopxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testAop(){
        ApplicationContext apx = new ClassPathXmlApplicationContext("beans-aop-pointcut.xml");
//        MathIml mathIml = (MathIml) apx.getBean("mathIml");

        //注意：使用aop注解，此处需要使用接口实现动态类，
        // 否则会报错java.lang.ClassCastException: com.sun.proxy.$Proxy13 cannot be cast to sm.dao.UserDao
        MathCal mathIml = (MathCal) apx.getBean("mathIml");

        System.out.println(mathIml.getClass().getName());
        int result1 = mathIml.add(2,3);
        System.out.println(result1);
        int result2 = mathIml.div(6,1);
        System.out.println(result2);
    }
}
