package com.example.java.book.test.lambda;

import java.util.List;

/**
 * @author Gen
 * @date 26/5/2020
 * @time 上午 10:55
 * Descriptioin 策略模式优化
 */
public interface MyPredicateGen<T>{
    List<T> getEmployeeByCon(List<T> list);
}
