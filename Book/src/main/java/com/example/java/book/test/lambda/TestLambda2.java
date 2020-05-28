package com.example.java.book.test.lambda;

import com.example.java.book.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gen
 * @date 26/5/2020
 * @time 上午 10:43
 * Descriptioin No Descriptioin
 */
public class TestLambda2 {

    private static List<Employee> list;
    static {
        list = Arrays.asList(
                new Employee("张三",23,3333.33),
                new Employee("李四",24,4444.44),
                new Employee("王五",25,5555.55),
                new Employee("赵六",26,6666.66),
                new Employee("田七",27,7777.77)
        );
    }

    //原始方法 : 查询出年龄大于25岁的(这个是最原始的方法)
    public List<Employee> findEmployeesByAge(List<Employee>list){
        List<Employee> emps = new ArrayList<>();
        for(Employee emp : list){
            if(emp.getAge() > 25){
                emps.add(emp);
            }
        }
        return emps;
    }

    //原始方法 : 查询出工资大于4000的(这个是最原始的方法)
    //和上面的方法唯一的差别只有年龄和工资的改动，代码冗余
    public List<Employee> findEmployeesBySalary(List<Employee>list){
        List<Employee> emps = new ArrayList<>();
        for(Employee emp : list){
            if(emp.getSalary() > 4000){
                emps.add(emp);
            }
        }
        return emps;
    }
    // 普通方法
    public void getEmployee(){
        List<Employee> ageList = findEmployeesByAge(list);
        List<Employee> salaryList = findEmployeesBySalary(list);
    }

    public void getEmployeeLamGen(){
        MyPredicateGen<Employee> myPredicate = (list) -> {
            List<Employee> ageEmployee = new ArrayList<>();
            list.forEach(employee -> {
                if (employee.getAge() > 25) ageEmployee.add(employee);
            });
            return ageEmployee;
        };
        List<Employee> ageList = myPredicate.getEmployeeByCon(list);
        ageList.forEach(employee -> System.out.println(employee.toString()));
    }




    public static void main(String[] args) {
        TestLambda2 test2 = new TestLambda2();
        test2.getEmployeeLamGen();
    }
}

















