package com.example.java.book.test;

import com.example.java.book.dao.abs.Shape;
import com.example.java.book.dao.factory.CirCle;
import com.example.java.book.dao.impl.GreenCircle;
import com.example.java.book.dao.impl.RedCircle;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/16
 * @time 15:49
 * 桥接模式练习
 * 使用Shape和DrawAPI类画出不同颜色的圆
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new CirCle(100,100,10,new RedCircle());
        Shape greenCircle = new CirCle(100,100,10,new GreenCircle());


        redCircle.draw();
        greenCircle.draw();
    }
}
