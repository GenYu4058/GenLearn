package com.example.java.book.model;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/9/3
 * @time 14:36
 * 被动引用示例
 */
class InitClass1{
    static {
        System.out.println("初始化InitClass");
    }
    public static String a = null;
    public final static String b = "b";
    public static void method(){}
}

class SubInitClass2 extends InitClass1{
    static {
        System.out.println("初始化SubInitClass");
    }
}

public class TestE {

    public static void main(String[] args) throws Exception{
        //	String a = SubInitClass.a;// 引用父类的静态字段，只会引起父类初始化，而不会引起子类的初始化
        //	String b = InitClass.b;// 使用类的常量不会引起类的初始化
        SubInitClass[] sc = new SubInitClass[10];// 定义类数组不会引起类的初始化
    }
}
