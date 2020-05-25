package com.example.java.book.test.lambda;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 25/5/2020
 * @time 下午 5:28
 * Descriptioin No Descriptioin
 */
public interface TestInterface {
    int getCount();
    String getName();
    default String getOther(){
        return "123";
    }
}
