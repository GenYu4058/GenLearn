package com.mashibing.juc.c_021_02_AQS;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 25/5/2020
 * @time ���� 3:46
 * Descriptioin No Descriptioin
 */
public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("Hello B! ���췽��");
    }
    {
        System.out.println("i'm B class.�Ǿ�̬�����");
    }
    static{
        System.out.println("static B ��̬�����");
    }
    public static void main(String[] args) {
        System.out.println("---start---");
        new HelloB();
        new HelloB();
        System.out.println("---end---");
    }
}
