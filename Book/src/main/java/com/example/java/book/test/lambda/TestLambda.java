package com.example.java.book.test.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author Gen
 * @date 8/5/2020
 * @time 下午 1:31
 * Descriptioin 练习Lambda
 */
public class TestLambda {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        // 普通遍历
        for (String player : players) {
            System.out.println("player = " + player);
        }


        //Lambda表达式遍历
        players.forEach((player) -> System.out.println("player = " + player));

        //使用了::遍历
        players.forEach(System.out::println);

    }



}
