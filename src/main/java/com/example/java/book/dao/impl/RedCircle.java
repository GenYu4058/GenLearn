package com.example.java.book.dao.impl;

import com.example.java.book.dao.DrawAPI;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/16
 * @time 15:24
 *  桥接模式练习
 *  创建实现了DrawAPI接口的实现桥接实现类
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y){
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ",x： " + x + "," + y + "]");
    }
}
