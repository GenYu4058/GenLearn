package com.example.java.book.test;

import com.example.java.book.model.TestD;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/9/2
 * @time 12:58
 * Java执行顺序test
 */
public class TestB extends TestA{
    public TestB(){
        System.out.println("子类构造方法");
    }
    {
        System.out.println("子类非静态代码块");
    }
    static{
        System.out.println("子类静态代码块");
    }

    public void A(){
        System.out.println("子类重写父类方法");
    }

    public static void main(String[] args) {
        System.out.println("---start---");
        new TestB();
        new TestB();
        System.out.println("---end---");
    }

}
