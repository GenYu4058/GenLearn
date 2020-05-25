package com.example.java.book.test.lambda;

import com.example.java.book.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gen
 * @date 8/5/2020
 * @time 下午 1:31
 * Descriptioin 练习Lambda
 */
public class TestLambda {



    public void lambda(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        players.forEach((player) -> System.out.println(""));

        // 普通遍历
        for (String player : players) {
            System.out.println("player = " + player);
        }

        //Lambda表达式遍历
        players.forEach((player) -> System.out.println("player = " + player));

        //使用了::遍历
        players.forEach(System.out::println);
    }




    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Book book = new Book(1,"2","3","4","5");
            bookList.add(book);
        }
        bookList.forEach((book) -> {

            System.out.println(book.getBookName());
            System.out.println(book.getBookId());


        });



        bookList.forEach(book -> System.out.println("book = " + book.getBookName()));
    }



}
