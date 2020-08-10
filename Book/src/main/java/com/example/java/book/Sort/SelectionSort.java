package com.example.java.book.Sort;

/**
 * 选择排序
 */
public class SelectionSort extends Sort {
    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return array;
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Sort s = new SelectionSort();
        s.printNum(s.sort(nums));
    }
}
