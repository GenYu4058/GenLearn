package com.example.java.book.Sort;

/**
 * @author Gen
 * @date 12/8/2020
 * @time 下午 3:29
 * 快速排序
 */
public class QuickSort extends Sort{

    @Override
    public int[] sort(int[] array) {

        return array;
    }


    /**
     * 左右指针法
     * partition操作
     * @param array
     * @param left 数列左边界
     * @param right 数列右边界
     * @return
     */
    public static int lefRigPoipartition(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        int key = right;

        while( begin < end ) {
            //begin找大
            while(begin < end && array[begin] <= array[key])
                begin++;
            //end找小
            while(begin < end && array[end] >= array[key])
                end--;
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;   //返回基准位置
    }

    /**
     * 挖坑法
     * @param array
     * @param left 数列左边界
     * @param right 数列右边界
     * @return
     */
    public static int digHolepartition(int[] array,int left,int right) {
        int key = array[right];//初始坑
        while(left < right) {
            //left找大
            while(left < right && array[left] <= key )
                left++;
            array[right] = array[left];//赋值，然后left作为新坑
            //right找小
            while(left <right && array[right] >= key)
                right--;
            array[left] = array[right];//right作为新坑
        }
        array[left] = key;
       /*将key赋值给left和right的相遇点，
        保持key的左边都是比key小的数，key的右边都是比key大的数*/
        return left;//最终返回基准
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int num1 = lefRigPoipartition(nums, nums[0], nums[nums.length-1]);
        int num2 = digHolepartition(nums, 0, nums.length-1);
        System.out.println(num1);
        System.out.println(num2);
    }
}
