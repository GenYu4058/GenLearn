package com.example.java.book.dao.impl;

import com.example.java.book.dao.AdvancedMediaPlayer;
import com.example.java.book.dao.MediaPlayer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/15
 * @time 14:52
 * 适配器模式练习
 * 创建实现了 MediaPlayer 接口的适配器类。
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
