package com.example.java.book.dao.abs;

import com.example.java.book.dao.Item;
import com.example.java.book.dao.Packing;
import com.example.java.book.dao.impl.Bottle;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:50
 * 建造者模式练习
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing(){
        return new Bottle();
    }

    @Override
    public abstract float price();
}
