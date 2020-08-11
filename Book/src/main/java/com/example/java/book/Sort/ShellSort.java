package com.example.java.book.Sort;

/**
 * @author Gen
 * @date 11/8/2020
 * @time 下午 2:01
 * 希尔排序
 */
public class ShellSort extends Sort{
    @Override
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0)
            return array;
        int current, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }
}
