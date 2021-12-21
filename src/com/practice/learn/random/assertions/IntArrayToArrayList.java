package com.practice.learn.random.assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There is no shortcut for converting from int[] to List<Integer> as Arrays.asList does not deal with boxing
 * and will just create a List<int[]> which is not what you want. You have to make a utility method.
 */
public class IntArrayToArrayList {
    public void convertToArrayList(){
        int[] ints = {1, 2, 3};
        List<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints) {
            intList.add(i);
        }
    }
    //Java 8
    public void convertToArrayList(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    //Java 16
    public void convertToArrayList2(int[] nums) {
        //List<Integer> list = Arrays.stream(nums).boxed().toList();
    }
}
