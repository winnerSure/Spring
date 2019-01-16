package spring.aopxml;

import org.springframework.stereotype.Component;

@Component("mathIml")   //写实现的接口组件
public class MathIml implements MathCal {
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }

//    public int sub(int i, int j) {
//        int result = i-j;
//        return result;
//    }

    public int div(int i, int j) {
        int result = i/j;
        return result;
    }
}
