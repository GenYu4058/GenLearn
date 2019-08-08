package com.example.java.book.model;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/8
 * @time 15:16
 * 单例模式：创建一个 Singleton 类。
 */
public class SingleObject {
    //创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();
    //让构造函数为private，这样该类就不会被实例化
    private SingleObject(){

    };
    //获取唯一可用的对象
    public static synchronized  SingleObject getInstance(){
        return  instance;
    }

    public void showMessage(){
        System.out.println("Hello World");
    }
}
