package com.example.java.book.test;

import com.example.java.book.dao.impl.AudioPlayer;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/15
 * @time 15:01
 * 适配器模式练习
 * 使用 AudioPlayer 来播放不同类型的音频格式。
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
