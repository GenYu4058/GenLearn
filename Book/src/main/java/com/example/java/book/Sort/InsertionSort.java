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

    /**
     * Description : 二分插入排序
     * @author GenYu
     * @date 11/8/2020 下午 1:23
     */
    public int[] BinaryInsertionSort(int[] array){
        if (array.length == 0)
            return array;
        for(int i = 1;i < array.length;i++) {
            int left = 0;
            int right = i - 1;  // left 和 right 分别为有序区的左右边界
            int current = array[i];
            while (left <= right) {
                //搜索有序区中第一个大于 current 的位置，即为 current 要插入的位置
                int mid = left + ((right - left) >> 1);
                if(array[mid] > current){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for(int j = i - 1;j >= left;j--) {
                array[j + 1] = array[j];
            }
            array[left] = current; // left 为第一个大于 current 的位置，插入 current
        }
        return array;
    }

    public static void main(String[] args) {
        Sort s = new InsertionSort();
        s.printNum(s.sort(nums));
    }
}















