package com.example.java.book.test;

import java.util.HashSet;
import java.util.Set;

public class test1 {
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));

    }



}
