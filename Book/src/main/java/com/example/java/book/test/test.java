package com.example.java.book.test;

public class test {
    public static void main(String[] args) {
        int i = 1234;
        Integer i1 = new Integer(1234);
        Integer i2 = new Integer(1234);
        System.out.print("i1 == i2 : "+(i1 == i2));
        System.out.println("\ti1.equals(i2) : "+(i1.equals(i2)));
        System.out.print("i == i1 : "+(i == i1));
        System.out.println("\t\ti1.equals(i) : "+(i1.equals(i)));
        System.out.print("i == i2 : "+(i == i2));
        System.out.println("\t\ti2.equals(i) : "+(i2.equals(i)));
        Object obj = new Object();
    }
}
