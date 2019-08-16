package com.example.java.book.dao.abs;

import com.example.java.book.dao.DrawAPI;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/16
 * @time 15:28
 *  桥接模式练习
 *  使用DrawAPI接口创建抽象类Shape
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
