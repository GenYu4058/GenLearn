package com.example.java.book.test;

import com.example.java.book.model.Meal;
import com.example.java.book.model.builder.MealBuilder;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 2019/8/13
 * @time 14:21
 * 建造者模式练习
 * 使用MealBuilder来演示建造者模式
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
