package com.example.java.book.test;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 20/7/2020
 * @time 下午 1:48
 * Description No Descriptioin
 */
public class test {

    /**
     * Description :
     * 不能调用系统库函数，诸如 Math.sqrt(v) 之类的；
     * 假设计算出的结果为 r，要求满足这个条件：  ，其中 是真实的值， t  为给定的一个误差范围，例如0.1等，即你计算出的值要在给定的误差范围内。
     * 实现语言不限，你条件可以比上述更加苛刻，但不能宽松。例如调用你的接口 sqrt(9, 0.21) 返回值属于 [2.79, 3.21] 这个区间的任意一个都满足条件。
     * @param v
     * @param t 为给定的一个误差范围，例如0.1等，即你计算出的值要在给定的误差范围内。
     * @return double
     * @author GenYu
     * @date 20/7/2020 下午 1:49
     */
    public static double sqrt(int v, double t) {
        double i = getIndex(v);
        while (true){
            i += t;
            if (i * i > v){
                return i;
            }
        }
    }

    /**
     * Description : 找到离V最近的数
     * @param v
     * @return int
     * @author GenYu
     * @date 20/7/2020 下午 2:15
     */
    public static double getIndex(int v){
        double i = 0.00;
        while (true){
            i ++;
            if (i*i > v){
                return i-1;
            }
        }
    }

    public static void main(String[] args) {
        double num = sqrt(24, 0.21);
        System.out.println(num);
    }


}
