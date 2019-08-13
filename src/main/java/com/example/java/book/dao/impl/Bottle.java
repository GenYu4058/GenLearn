package com.example.java.book.dao.impl;

import com.example.java.book.dao.Packing;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:43
 * 建造者模式练习
 * 创建实现 Packing 接口的实体类。
 */
public class Bottle implements Packing {
    @Override
    public String pack(){
        return "Bottle";
    }
}
