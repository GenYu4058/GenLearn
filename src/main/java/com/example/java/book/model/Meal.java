package com.example.java.book.model;

import com.example.java.book.dao.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 14:09
 * 建造者模式练习
 * 创建一个Meal类，带有上面定义的Item对象
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items){
            System.out.println("Item :" + item.name());
            System.out.println(", Packing :" + item.packing().pack());
            System.out.println(", Price :" + item.price());
        }
    }

}
