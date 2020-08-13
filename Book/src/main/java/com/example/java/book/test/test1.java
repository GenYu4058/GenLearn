package com.example.java.book.test;

import com.example.java.book.model.Book;

import java.lang.reflect.Array;
import java.util.*;

public class test1 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Book book = new Book(i, "1","1","1", "1");
            list.add(book);
        }


    }



}
