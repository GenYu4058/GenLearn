package com.example.java.book.model;

/**
 * @author Gen
 * @date 26/5/2020
 * @time 上午 10:42
 * Descriptioin 测试Lambda
 */
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }
}