package com.example.java.book.model;

import com.example.java.book.model.abs.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/14
 * @time 16:28
 * Descriptioin No Descriptioin
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type = "";
    }

    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}
