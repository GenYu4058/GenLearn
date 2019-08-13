package com.example.java.book.dao.abs;

import com.example.java.book.dao.Item;
import com.example.java.book.dao.Packing;
import com.example.java.book.dao.impl.Wrapper;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:46
 * 建造者模式练习
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing(){
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
