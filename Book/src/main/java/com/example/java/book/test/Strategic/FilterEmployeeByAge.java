package com.example.java.book.test.Strategic;

import com.example.java.book.model.Employee;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 26/5/2020
 * @time 下午 3:07
 * Descriptioin No Descriptioin
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 25;
    }
}
