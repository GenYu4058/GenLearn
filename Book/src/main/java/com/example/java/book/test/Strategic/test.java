package com.example.java.book.test.Strategic;

import com.example.java.book.model.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 26/5/2020
 * @time 下午 3:10
 * Descriptioin No Descriptioin
 */
public class test {
    private List<Employee> list;
    static {
         list = Arrays.asList(
                new Employee("张三",23,3333.33),
                new Employee("李四",24,4444.44),
                new Employee("王五",25,5555.55),
                new Employee("赵六",26,6666.66),
                new Employee("田七",27,7777.77)
        );
    }
    public static void main(String[] args) {
        () -> list
    }
}
