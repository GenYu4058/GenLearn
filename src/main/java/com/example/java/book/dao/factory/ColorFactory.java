package com.example.java.book.dao.factory;

import com.example.java.book.dao.Color;
import com.example.java.book.dao.Shape;
import com.example.java.book.dao.impl.Blue;
import com.example.java.book.dao.impl.Green;
import com.example.java.book.dao.impl.Red;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/8
 * @time 10:17
 * 抽象工厂练习，color工厂类
 */
public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color){
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }else if (color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
