package com.example.java.book.model;

import com.example.java.book.dao.abs.ColdDrink;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 14:04
 * 建造者模式练习
 * 创建扩展了Burger和ColdDrink的实体类
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price(){
        return 35.0f;
    }

    @Override
    public String name(){
        return "Pepsi";
    }

}
