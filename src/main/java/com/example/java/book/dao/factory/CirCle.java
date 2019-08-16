package com.example.java.book.dao.factory;

import com.example.java.book.dao.DrawAPI;
import com.example.java.book.dao.abs.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/16
 * @time 15:39
 *  桥接模式练习
 *  创建实现了Shape接口的实现类
 */
public class CirCle extends Shape {
    private int x,y,radius;

    public CirCle(int x, int y, int radius, DrawAPI drawAPI){
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        drawAPI.drawCircle(radius, x, y);
    }
}
