package com.example.java.book.dao.impl;

import com.example.java.book.dao.Color;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/8
 * @time 10:00
 * 抽象工厂练习实现类
 */
public class Red implements Color {
    @Override
    public void fill(){
        System.out.println("Inside Red::fill() method");
    }
}
