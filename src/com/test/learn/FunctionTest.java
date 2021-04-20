package com.test.learn;

import java.lang.reflect.Method;
import java.util.function.Function;

public class FunctionTest {

    Function<String, String> f1 = inp -> {
        return inp + "----Added";
    };

    Function<String, String> f2 = inp -> {
        return inp + "----Subtract";
    };

    public Function test3() {
        Function<String, String> f3 = (inp1) -> {
            return inp1 + "----divide";
        };
        return f3;
    }



    public static void main(String[] args) throws Exception{
        Class classObj = FunctionTest.class;
        Method[] methods = classObj.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
            if (method.getName() =="test3")
                method.invoke(null);
        }
//        System.out.println(new FunctionTest().test3().apply("my test"));
    }
}
