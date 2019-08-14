package com.example.java.book.model;

import com.example.java.book.model.abs.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/14
 * @time 16:23
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}
