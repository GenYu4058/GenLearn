package com.example.java.book.dao;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 13:40
 * 建造者模式练习
 * 创建一个表示食物条目和食物包装的接口。
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
