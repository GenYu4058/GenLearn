package com.example.java.book.dao;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/15
 * @time 14:46
 * 适配器模式练习
 * 为媒体播放器和更高级的媒体播放器创建接口。
 */
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}
