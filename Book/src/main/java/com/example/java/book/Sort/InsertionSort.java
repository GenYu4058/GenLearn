package com.example.java.book.Sort;

/**
 * 插入排序
 */
public class InsertionSort extends Sort{
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        Sort s = new InsertionSort();
        s.printNum(s.sort(nums));
    }
}
