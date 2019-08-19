package com.duy.demo.KFCmeal;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/7 14:34
 **/
public class T {
    public static void main(String[] args) {
        //A套餐
        Meal mealA = new KFCWaiter(new MealA()).construct();
        System.out.println(mealA.getDrink()+mealA.getFood());

        //B套餐
        Meal mealB = new KFCWaiter(new MealB()).construct();
        System.out.println(mealB.getDrink()+mealB.getFood());
    }
}
