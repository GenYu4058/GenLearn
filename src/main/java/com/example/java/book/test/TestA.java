package com.example.java.book.test;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/9/2
 * @time 12:56
 * Java执行顺序test
 */
public class TestA {
    public TestA(){
        System.out.println("父类构造方法");
    }
    {
        System.out.println("父类非静态代码快");
    }
    static{
        System.out.println("父类静态代码块");
    }
    public static void test1()
    {
        System.out.println("父类静态代码");
    }


    public void B(){

    }
    protected void A(){
        System.out.println("父类普通方法");
    }
}
