package com.duy.demo.KFCmeal;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/7 14:19
 **/
public class MealA extends MealBuilder{
    @Override
    public void buildFood() {
        meal.setDrink("可乐");
    }

    @Override
    public void buildDrink() {
        meal.setFood("薯条");
    }
}
