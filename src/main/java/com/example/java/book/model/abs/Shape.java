package com.example.java.book.model.abs;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/14
 * @time 16:23
 * 原型模式练习
 * 创建一个实现了 Cloneable 接口的抽象类。
 */
public abstract class Shape implements Cloneable{
    private String id;
    public String type;

    public abstract void draw();

    public String getType(){
        return type;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
