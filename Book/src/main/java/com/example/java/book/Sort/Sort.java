package com.example.java.book.Sort;

public abstract class Sort {
    public static int[] nums = {3, 38, 5, 44, 15, 36, 26, 27, 47, 2, 26, 4, 19, 50, 48};

    public abstract int[] sort(int[] array);

    public void printNum(int[] array){
        for(int value : array){
            System.out.print(value + " ");
        }
    }


}
