package com.example.java.book.model;

import com.example.java.book.dao.abs.Burger;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:57
 * 建造者模式练习
 * 创建扩展了Burger和ColdDrink的实体类
 */
public class VegBurger extends Burger {
    @Override
    public float price(){
        return 25.0f;
    }

    @Override
    public String name(){
        return "Veg Burger";
    }
}
