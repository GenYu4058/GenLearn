package com.example.java.book.test;

import com.example.java.book.dao.Color;
import com.example.java.book.dao.Shape;
import com.example.java.book.dao.factory.AbstractFactory;
import com.example.java.book.dao.factory.FactoryProducer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/8
 * @time 13:50
 * 使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为Circle的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用Circle的draw方法
        shape1.draw();

        //获取形状为Rectangle的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用Rectangle的draw方法
        shape2.draw();

        //获取形状为Square的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用Square的draw方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("RED");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");

        //调用 Blue 的 fill 方法
        color3.fill();
    }
}
























