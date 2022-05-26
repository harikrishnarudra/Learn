package com.practice.learn;

import java.awt.*;
import java.nio.file.DirectoryStream;
import java.util.function.Function;

public class FuncApplyCheck {
      String doFunc(Integer i, Function<Integer, String> f){
        return f.apply(i);
    }
    void notAValidLambdaExpr(){
        DirectoryStream.Filter<String> stringFilter = (String a) -> false;
        KeyEventDispatcher keyEventDispatcher = a -> false;
        KeyEventDispatcher keyEventDispatcher1 = (a) -> false;
//        String a -> false;  - NOT ALLOWED
    }
}

class Unicorn{
//    static Unicorn(){} Static constructor is not allowed
}
