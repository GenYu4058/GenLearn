package com.example.java.book.dao.impl;

import com.example.java.book.dao.AdvancedMediaPlayer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/15
 * @time 14:48
 * 适配器模式练习
 * 创建实现了 AdvancedMediaPlayer 接口的实体类。
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName){
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName){
        //什么也不做
    }
}
