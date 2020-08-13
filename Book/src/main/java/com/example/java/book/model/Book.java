package com.example.java.book.model;


import java.util.Comparator;

/**
 * Book实体类
 *
 * @author GenYu
 * @date 2019/01/29
 */
public class Book implements Comparable<Book>{
    private int bookId;
    private String bookNumber;
    private String bookName;
    private String bookDescribe;
    private String bookType;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescribe() {
        return bookDescribe;
    }

    public void setBookDescribe(String bookDescribe) {
        this.bookDescribe = bookDescribe;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Book(int bookId, String bookNumber, String bookName, String bookDescribe, String bookType) {
        this.bookId = bookId;
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookDescribe = bookDescribe;
        this.bookType = bookType;
    }

    public Book(){ }


    @Override
    public int compareTo(Book o) {
        Integer id1 = this.getBookId();
        Integer id2 = o.getBookId();
        return id1.compareTo(id2);
    }
}
