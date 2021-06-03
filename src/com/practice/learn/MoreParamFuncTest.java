package com.test.learn;

public class MoreParamFuncTest {

    private MoreParamFunctionInt getFunc(){
        MoreParamFunctionInt val = (inp1, inp2) -> {
            if (inp1.equalsIgnoreCase(inp2)) {
                return true;
            }
            return false;
        };
        return val;
    }

    public static void main(String[] args) {

        System.out.println(new MoreParamFuncTest().getFunc().applyFunc("test", "test"));
        System.out.println(new MoreParamFuncTest().getFunc().applyFunc("test", "test2"));
    }
}
