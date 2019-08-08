package com.example.java.book.test;

import com.example.java.book.model.SingleObject;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/8
 * @time 15:21
 * 单例模式练习：从 singleton 类获取唯一的对象。
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误，构造函数SingleObject()是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
}
