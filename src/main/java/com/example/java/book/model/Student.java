package com.example.java.book.model;

public class Student {
    //属性
    private int age = 18;
    private String name = "Gen";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //------------构造方法------------
    //默认的构造方法
    Student(String str){
        System.out.println("默认的构造方法 s = " + str);
    }

    //无参的构造方法
    public Student(){
        System.out.println("调用了公有，无参构造方法执行了");
    }

    //有一个参数的构造方法
    public Student(char name){
        System.out.println("有一个参数的构造方法执行，姓名 = " + name);
    }

    //有多个参数的构造方法
    public Student(String name, int age){
        System.out.println("有多个参数的构造方法执行，姓名 = " + name +",年龄 = " + age);
    }

    //受保护的构造方法
    protected Student(boolean n){
        System.out.println("受保护的构造方法执行，n = " + n);
    }

    //私有的构造方法
    private Student(int age){
        System.out.println("私有的构造方法执行，年龄 = " + age);
    }

    //普通方法01
    public boolean testStudent(String name){
        System.out.println("调用普通方法01被调用，传入参数,name = " + name);
        return true;
    }

    //普通方法02
    public String testStudent(boolean bo){
        System.out.println("调用普通方法02被调用，传入参数,bo = " + bo);
        return "普通方法02被调用";
    }

}