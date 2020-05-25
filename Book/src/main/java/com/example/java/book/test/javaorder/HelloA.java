package com.example.java.book.test.javaorder;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 25/5/2020
 * @time 下午 3:49
 * Descriptioin No Descriptioin
 */
public class HelloA {
    public HelloA(){
        System.out.println("Hello A!父类构造方法");
    }
    {
        System.out.println("i'm A class.父类非静态代码块");
    }
    static{
        System.out.println("static A 父类静态代码块");
    }
}
