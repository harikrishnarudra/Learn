package com.practice.learn.random.assertions;

import java.util.function.IntUnaryOperator;

/**
 * It can do
 * 1. Identity  - This method returns an IntUnaryOperator which takes in one int value and returns it. The returned IntUnaryOperator does not perform any operation on its only value.Just returns the same element
 * 2. applyAsInt() - This method takes in one int value, performs the given operation and returns an int-valued result.
 * 3. andThen() - It returns a composed IntUnaryOperator wherein the parameterized operator will be executed after the first one.
 * 4. Compose() - It returns a composed IntUnaryOperator wherein the parameterized operation will be executed first and then the first one.
 */

public class IntUnaryOperatorImpl {
    public static void main(String[] args) {
        IntUnaryOperator op = IntUnaryOperator.identity();
        System.out.println(op.applyAsInt(12));

        IntUnaryOperator op1 = a -> 2 * a;
        System.out.println(op1.applyAsInt(12));

        IntUnaryOperator op2 = a -> 2 * a;
        op2 = op2.andThen(a -> 3 * a);
        op2 = op2.andThen(a -> a/2);
        System.out.println(op2.applyAsInt(12));

        IntUnaryOperator op4 = a -> a / 3;
        op4 = op4.compose(a -> a * 6);
        System.out.println(op4.applyAsInt(12));
    }

}
