package com.example.java.book.dao.impl;

import com.example.java.book.dao.AdvancedMediaPlayer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/15
 * @time 14:50
 * 适配器模式练习
 * 创建实现了 AdvancedMediaPlayer 接口的实体类。
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName){
        //什么也不做
    }

    @Override
    public void playMp4(String fileName){
        System.out.println("Playing mp4 file. Name:" + fileName);
    }
}
