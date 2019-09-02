package com.example.java.book.test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/9/2
 * @time 13:17
 * Java执行顺序test
 */
public class TestC {
    public static void main(String[] args) {
        System.out.println("start");
        new TestB();
        new TestB();
        System.out.println("end");
    }

    public void test() throws Exception,ClassNotFoundException{
        //TODO
        throw new IOException();
    }
}
