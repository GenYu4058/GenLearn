package com.example.java.book.dao.factory;

import com.example.java.book.dao.Shape;
import com.example.java.book.dao.impl.Circle;
import com.example.java.book.dao.impl.Rectangle;
import com.example.java.book.dao.impl.Square;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/6
 * @time 10:41
 * shape工厂类
 */
public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;

    }


}
