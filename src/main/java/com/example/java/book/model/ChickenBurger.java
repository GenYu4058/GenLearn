package com.example.java.book.model;

import com.example.java.book.dao.abs.Burger;

import java.nio.Buffer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:59
 * 建造者模式练习
 * 创建扩展了Burger和ColdDrink的实体类
 */
public class ChickenBurger extends Burger {
    @Override
    public  float price(){
        return 50.5f;
    }

    @Override
    public String name(){
        return "Chicken Burger";
    }
}
