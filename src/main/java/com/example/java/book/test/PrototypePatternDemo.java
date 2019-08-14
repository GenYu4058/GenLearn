package com.example.java.book.test;

import com.example.java.book.model.Cache.ShapeCache;
import com.example.java.book.model.abs.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/14
 * @time 16:23
 * 原则模式练习
 * PrototypePatternDemo 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆。
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
