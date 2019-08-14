package com.example.java.book.model;

import com.example.java.book.model.abs.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/14
 * @time 16:23
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}
