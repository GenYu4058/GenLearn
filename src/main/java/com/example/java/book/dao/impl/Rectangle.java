package com.example.java.book.dao.impl;

import com.example.java.book.dao.Shape;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/6
 * @time 10:36
 * 工厂模式实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}
